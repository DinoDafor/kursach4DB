package com.groupName.artifactName.code;

public class OrderRequest {
    String family;
    Integer orderId;

    public String getFamilyName() {
        return family;
    }

    public void setFamilyName(String family) {
        this.family = family;
    }

    public Integer getOrderID() {
        return orderId;
    }

    public void setOrderID(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderRequest(String family, Integer orderId) {
        this.family = family;
        this.orderId = orderId;
    }

}
