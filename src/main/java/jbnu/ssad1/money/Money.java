package jbnu.ssad1.money;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal money;

    public Money(BigDecimal money) {
        this.money = money;
    }

    public static Money wons(long money) {
        return new Money(BigDecimal.valueOf(money));
    }

    public static Money wons(double money) {
        return new Money(BigDecimal.valueOf(money));
    }

    public Money plus(Money other) {
        return new Money(this.money.add(other.money));
    }

    public Money minus(Money other) {
        return new Money(this.money.subtract(other.money));
    }

    public Money times(double percent) {
        return new Money(this.money.multiply(BigDecimal.valueOf(percent)));
    }
}