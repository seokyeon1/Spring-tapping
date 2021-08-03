package hello.Halo;

import hello.Halo.member.Grade;
import hello.Halo.member.Member;
import hello.Halo.member.MemberService;
import hello.Halo.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Memberapp {

    public static void main(String[] args) {
//       ' AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();'

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
