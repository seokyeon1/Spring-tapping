package hello.Halo.discount;

import hello.Halo.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
