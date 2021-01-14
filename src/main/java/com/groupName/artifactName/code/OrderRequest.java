package com.groupName.artifactName.code;

public class OrderRequest {
    String familyName;
    Integer orderID;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public OrderRequest(String familyName, Integer orderID) {
        this.familyName = familyName;
        this.orderID = orderID;
    }

}
