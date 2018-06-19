package com.shopmanager.entity;

public class OrderList {

    private int cartid;

    private int proid;

    private String proname;

    private int buy_num;

    private int price;

    private String size;

    private int cart_state;

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

    public int getCart_state() {
        return cart_state;
    }

    public void setCart_state(int cart_state) {
        this.cart_state = cart_state;
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

    @Override
    public String toString() {
        return "OrderList{" +
                "cartid=" + cartid +
                ", proid=" + proid +
                ", proname='" + proname + '\'' +
                ", buy_num=" + buy_num +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", cart_state=" + cart_state +
                '}';
    }
}
