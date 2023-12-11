package jbnu.ssad1.medel.entity;

import jbnu.ssad1.discount.Coupon;
import jbnu.ssad1.discount.RateDiscountPolicy;
import jbnu.ssad1.money.Money;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private Long id;
    private String email;
    private String password;
    private String name;
    private Money point;
    private List<Coupon> coupons;

    public Member() {

    }

    public Member(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.point = Money.wons(1000L);
        this.coupons = new ArrayList<>(List.of(new Coupon(new RateDiscountPolicy(0.1))));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPoint() {
        return point;
    }

    public void setPoint(Money point) {
        this.point = point;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}
