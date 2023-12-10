package jbnu.ssad1.money;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Money money1 = (Money) object;
        return Objects.equals(money.doubleValue(), money1.money.doubleValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public Money times(double percent) {
        return new Money(this.money.multiply(BigDecimal.valueOf(percent)));
    }

    @Override
    public String toString() {
        return money.toString() + "W";
    }
}