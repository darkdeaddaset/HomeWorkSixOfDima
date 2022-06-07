package com.savin.dto.shop;

public class ShopDTO {
    private long id;
    private String name;
    private String area;
    private int commissary;

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
