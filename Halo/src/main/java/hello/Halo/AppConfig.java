package hello.Halo;

import hello.Halo.discount.DiscountPolicy;
import hello.Halo.discount.RateDiscountPolicy;
import hello.Halo.member.MemberService;
import hello.Halo.member.MemberServiceImpl;
import hello.Halo.member.MemoryMemberRepository;
import hello.Halo.order.OrderService;
import hello.Halo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
