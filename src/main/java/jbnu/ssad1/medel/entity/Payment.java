package jbnu.ssad1.medel.entity;

import jbnu.ssad1.discount.Coupon;
import jbnu.ssad1.money.Money;

import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private Booking booking;
    private Money paymentAmount;
    private Coupon usedCoupon;
    private Money usedPoint;
    private LocalDateTime paymentTime;

    public Payment(Booking booking, Money paymentAmount, Coupon usedCoupon, Money usedPoint, LocalDateTime paymentTime) {
        this.booking = booking;
        this.paymentAmount = paymentAmount;
        this.usedCoupon = usedCoupon;
        this.usedPoint = usedPoint;
        this.paymentTime = paymentTime;
    }

    public Payment(Booking booking, Coupon usedCoupon, Money usedPoint) {
        this.booking = booking;
        this.usedCoupon = usedCoupon;
        this.usedPoint = usedPoint;
        this.paymentAmount = Money.wons(15000L);
        this.paymentTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Money getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Money paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Coupon getUsedCoupon() {
        return usedCoupon;
    }

    public void setUsedCoupon(Coupon usedCoupon) {
        this.usedCoupon = usedCoupon;
    }

    public Money getUsedPoint() {
        return usedPoint;
    }

    public void setUsedPoint(Money usedPoint) {
        this.usedPoint = usedPoint;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}
