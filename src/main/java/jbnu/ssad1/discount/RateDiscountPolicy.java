package jbnu.ssad1.discount;

import jbnu.ssad1.money.Money;

public class RateDiscountPolicy implements  DiscountPolicy {

    private final double percent;

    public RateDiscountPolicy(double percent) {
        this.percent = percent;
    }

    @Override
    public Money calculateDiscountAmount(Money price) {
        return price.times(percent);
    }

    @Override
    public String toString() {
        return percent * 100 + "% 할인";
    }
}
