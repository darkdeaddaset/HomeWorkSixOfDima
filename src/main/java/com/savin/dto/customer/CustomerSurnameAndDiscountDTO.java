package com.savin.dto.customer;

public class CustomerSurnameAndDiscountDTO {
    private String surname;
    private int discount;

    public CustomerSurnameAndDiscountDTO(String surname, int discount) {
        this.surname = surname;
        this.discount = discount;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
