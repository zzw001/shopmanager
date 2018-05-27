package com.shopmanager.model;

public class Transportation {
    private String tranId;

    private Integer trerId;

    private Integer cartId;

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId == null ? null : tranId.trim();
    }

    public Integer getTrerId() {
        return trerId;
    }

    public void setTrerId(Integer trerId) {
        this.trerId = trerId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
}