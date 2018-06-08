package com.shopmanager.model;

public class Shopcart {
    private Integer cartId;

    private Integer userId;

    private Integer proId;

    private Integer buyNum;

    private Integer cartState;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getCartState() {
        return cartState;
    }

    public void setCartState(Integer cartState) {
        this.cartState = cartState;
    }
}