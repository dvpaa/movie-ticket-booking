package jbnu.ssad1.medel.dto;


import jbnu.ssad1.discount.Coupon;
import jbnu.ssad1.money.Money;

import java.util.List;

public class MemberParameter {
    private String email;
    private String password;
    private String name;

    private Money point;

    private List<Coupon> coupons;

    public MemberParameter(String email, String password, String name, Money point, List<Coupon> coupons) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.point = point;
        this.coupons = coupons;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Money getPoint() {
        return point;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }
}
