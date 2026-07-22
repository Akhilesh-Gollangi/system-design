package com.ecommercediscount;

public class Discount {

    public static void main(String[] args) {
        DiscountManagement discountManagement = new DiscountManagement();
        discountManagement.discount(new CouponDiscount());
        discountManagement.discount(new CreditcardDiscount());
    }
}
