package com.savin.dto.customer;

public class CustomerNameAndHomeAndDiscountOnly {
    private String name;
    private String home;
    private int discount;

    public CustomerNameAndHomeAndDiscountOnly(){}

    public CustomerNameAndHomeAndDiscountOnly(String name, String home, int discount) {
        this.name = name;
        this.home = home;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
