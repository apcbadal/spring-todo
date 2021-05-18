package com.example.ToDoApplication.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.sql.Timestamp;

public class ProductDTO {
    @JsonDeserialize
    private Long uniqueId;
    private String productName;
    private Long productQty;
    private Double productPrice;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @JsonDeserialize
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductQty() {
        return productQty;
    }

    public void setProductQty(Long productQty) {
        this.productQty = productQty;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }



}
