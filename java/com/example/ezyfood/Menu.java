package com.example.ezyfood;

public class Menu {
    private String name;
    private int price;
    private int id;
    private int image;
    private int qty;
    private int totalPrice;
    private int balance;

    public Menu(int id, String name, int price, int image, int qty, int totalPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public int getQty() { return qty; }

    public int getTotalPrice() { return totalPrice; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setQty(int qty) { this.qty = qty; }

    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }

}
