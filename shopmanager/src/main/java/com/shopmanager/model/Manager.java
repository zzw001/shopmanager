package com.shopmanager.model;

public class Manager {
    private Integer manaId;

    private String manaName;

    private String manaPassword;

    public Integer getManaId() {
        return manaId;
    }

    public void setManaId(Integer manaId) {
        this.manaId = manaId;
    }

    public String getManaName() {
        return manaName;
    }

    public void setManaName(String manaName) {
        this.manaName = manaName == null ? null : manaName.trim();
    }

    public String getManaPassword() {
        return manaPassword;
    }

    public void setManaPassword(String manaPassword) {
        this.manaPassword = manaPassword == null ? null : manaPassword.trim();
    }
}