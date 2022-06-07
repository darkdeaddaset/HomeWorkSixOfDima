package com.savin.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "buy")
public class Buying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "shop_id")
    private Shop shop;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id")
    private Books books;
    @Column(name = "quanity")
    private int quantity;
    @Column(name = "price", nullable = false)
    private int price;

    public Buying() {
    }

    public Buying(Shop shop, Customer customer, Books books,
                  int quantity, int price){
        this.shop = shop;
        this.customer = customer;
        this.books = books;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quanity) {
        this.quantity = quanity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
