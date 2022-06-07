package com.savin.dto.buying;

public class BuyingNameAndPriceAndStockAndQuantityDTO {
    private String name;
    private int price;
    private String stock;
    private int quantity;

    public BuyingNameAndPriceAndStockAndQuantityDTO(String name, int price, String stock, int quantity) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
