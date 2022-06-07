package com.savin.dto.buying;

import java.util.Date;

public class BuyingDateAndQuantityAndSurnameAndDiscountDTO {
    private Date date;
    private int quantity;
    private String surname;
    private int discount;
    private String name;

    public BuyingDateAndQuantityAndSurnameAndDiscountDTO(Date date, int quantity, String surname, int discount, String name) {
        this.date = date;
        this.quantity = quantity;
        this.surname = surname;
        this.discount = discount;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
