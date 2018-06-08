package com.shopmanager.model;

public class Transporter {
    private Integer trerId;

    private String trerName;

    private String trerPassword;

    public Integer getTrerId() {
        return trerId;
    }

    public void setTrerId(Integer trerId) {
        this.trerId = trerId;
    }

    public String getTrerName() {
        return trerName;
    }

    public void setTrerName(String trerName) {
        this.trerName = trerName == null ? null : trerName.trim();
    }

    public String getTrerPassword() {
        return trerPassword;
    }

    public void setTrerPassword(String trerPassword) {
        this.trerPassword = trerPassword == null ? null : trerPassword.trim();
    }
}