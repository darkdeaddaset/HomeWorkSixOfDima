package com.savin.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "surname", length = 30, nullable = false)
    private String surname;
    @Column(name = "home", length = 50, nullable = false)
    private String home;
    @Column(name = "discount")
    private int discount;

    public Customer(){}

    public Customer(String surname, String home, int discount){
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
