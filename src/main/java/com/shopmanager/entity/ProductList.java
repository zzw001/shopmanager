package com.shopmanager.entity;

public class ProductList {

    private String proname;

    private String catagory;

    private int price;

    private String size;

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "proname='" + proname + '\'' +
                ", catagory='" + catagory + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
