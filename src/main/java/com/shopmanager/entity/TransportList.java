package com.shopmanager.entity;

public class TransportList {

    private String tranid;

    private int cartid;

    private int userid;

    private String username;

    private int proid;

    private String proname;

    private String size;

    private int buy_num;

    private String catagory;

    private int state;

    public String getTranid() {
        return tranid;
    }

    public void setTranid(String tranid) {
        this.tranid = tranid;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(int buy_num) {
        this.buy_num = buy_num;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TransportList{" +
                "tranid=" + tranid +
                ", cartid=" + cartid +
                ", username='" + username + '\'' +
                ", proid=" + proid +
                ", proname='" + proname + '\'' +
                ", size='" + size + '\'' +
                ", buy_num=" + buy_num +
                ", catagory='" + catagory + '\'' +
                ", state=" + state +
                '}';
    }
}
