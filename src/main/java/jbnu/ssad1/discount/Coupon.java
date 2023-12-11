package jbnu.ssad1.discount;

import jbnu.ssad1.money.Money;

public class Coupon {
    private final DiscountPolicy discountPolicy;

    public Coupon(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Money discount(Money price) {
        return price.minus(discountPolicy.calculateDiscountAmount(price));
    }

    @Override
    public String toString() {
        return discountPolicy.toString();
    }
}
