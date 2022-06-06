package com.savin.dto.buying;

import com.savin.model.Books;
import com.savin.model.Customer;
import com.savin.model.Shop;

import java.util.Date;

public class BuyingDTO {
    private long id;
    private Date date;
    private Shop shop;
    private Customer customer;
    private Books books;
    private int quanity;
    private int price;

    public BuyingDTO(){}

    public BuyingDTO(long id, Date date, Shop shop, Customer customer, Books books, int quanity, int price) {
        this.id = id;
        this.date = date;
        this.shop = shop;
        this.customer = customer;
        this.books = books;
        this.quanity = quanity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
