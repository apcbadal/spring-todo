package com.example.ToDoApplication.dto;

import com.example.ToDoApplication.model.Product;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

public class ProductCategoryDTO {
    private Long uniqueId;
    private String category;
    private List<ProductDTO> productList;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
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
