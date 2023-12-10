package jbnu.ssad1.discount;

import jbnu.ssad1.money.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CouponTest {

    @Test
    void rateDiscountTest() {
        Money price = Money.wons(15000L);
        Coupon coupon = new Coupon(new RateDiscountPolicy(0.1));
        assertThat(coupon.discount(price)).isEqualTo(Money.wons(13500L));
    }

    @Test
    void fixedDiscountTest() {
        Money price = Money.wons(15000L);
        Coupon coupon = new Coupon(new FixedDiscountPolicy(Money.wons(1000L)));
        assertThat(coupon.discount(price)).isEqualTo(Money.wons(14000L));
    }
}