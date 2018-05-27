package com.shopmanager.model;

public class Catagory {
    private Integer cataId;

    private String cataName;

    public Integer getCataId() {
        return cataId;
    }

    public void setCataId(Integer cataId) {
        this.cataId = cataId;
    }

    public String getCataName() {
        return cataName;
    }

    public void setCataName(String cataName) {
        this.cataName = cataName == null ? null : cataName.trim();
    }
}