package com.savin.model;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name = "area", length = 50, nullable = false)
    private String area;
    @Column(name = "commissary")
    private int commissary;

    public Shop(){}

    public Shop(String name, String area, int commissary){
        this.name = name;
        this.area = area;
        this.commissary = commissary;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCommissary() {
        return commissary;
    }

    public void setCommissary(int commissary) {
        this.commissary = commissary;
    }
}
