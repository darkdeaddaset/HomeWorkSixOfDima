package com.savin.dto.customer;

public class CustomerDTO {
    private long id;
    private String surname;
    private String home;
    private int discount;

    public CustomerDTO(){}

    public CustomerDTO(long id, String surname, String home, int discount) {
        this.id = id;
        this.surname = surname;
        this.home = home;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
