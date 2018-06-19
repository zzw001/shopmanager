package com.shopmanager.entity;

public class ShopcartList {

    private int cartid;

    private int proid;

    private String proname;

    private int buy_num;

    private int price;

    private int buy_price;

    private String size;

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public int getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(int buy_num) {
        this.buy_num = buy_num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(int buy_price) {
        this.buy_price = buy_price;
    }

    @Override
    public String toString() {
        return "ShopcartList{" +
                "cartid=" + cartid +
                ", proid=" + proid +
                ", proname='" + proname + '\'' +
                ", buy_num=" + buy_num +
                ", price=" + price +
                ", buy_price=" + buy_price +
                ", size='" + size + '\'' +
                '}';
    }
}
