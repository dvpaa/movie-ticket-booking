package jbnu.ssad1.discount;

import jbnu.ssad1.money.Money;

public interface DiscountPolicy {

    /**
     * @param 영화 가격
     * @return 할인할 금액
     */
    Money calculateDiscountAmount(Money price);
}


