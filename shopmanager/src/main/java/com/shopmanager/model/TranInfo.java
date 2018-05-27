package com.shopmanager.model;

public class TranInfo {
    private Integer tranInfoId;

    private String tranId;

    private String tranInfoContext;

    public Integer getTranInfoId() {
        return tranInfoId;
    }

    public void setTranInfoId(Integer tranInfoId) {
        this.tranInfoId = tranInfoId;
    }

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId == null ? null : tranId.trim();
    }

    public String getTranInfoContext() {
        return tranInfoContext;
    }

    public void setTranInfoContext(String tranInfoContext) {
        this.tranInfoContext = tranInfoContext == null ? null : tranInfoContext.trim();
    }
}