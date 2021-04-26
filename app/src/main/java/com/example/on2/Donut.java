package com.example.on2;

public class Donut {
    private String name;
    private String price;
    private int imgHinh;

    public Donut(String name, String price, int imgHinh) {
        this.name = name;
        this.price = price;
        this.imgHinh = imgHinh;
    }

    public Donut() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImgHinh() {
        return imgHinh;
    }

    public void setImgHinh(int imgHinh) {
        this.imgHinh = imgHinh;
    }
}
