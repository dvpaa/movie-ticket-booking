package jbnu.ssad1.discount;

import jbnu.ssad1.money.Money;

public class FixedDiscountPolicy implements DiscountPolicy {

    private final Money discount;

    public FixedDiscountPolicy(Money discount) {
        this.discount = discount;
    }

    @Override
    public Money calculateDiscountAmount(Money price) {
        return discount;
    }

    @Override
    public String toString() {
        return discount + " 할인";
    }
}
