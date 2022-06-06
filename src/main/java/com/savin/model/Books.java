package com.savin.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "stock", length = 50, nullable = false)
    private String stock;
    @Column(name = "count")
    private int count;

    public Books(){}

    public Books(String name, int price,
                 String stock, int count){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
