package com.example.ToDoApplication.model;


import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_id")
    private Long uniqueId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "producy_qty")
    private Long productQty;
    @Basic
    @Column(name = "product_price")
    private Double productPrice;
    @Basic
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "productCategory",referencedColumnName = "unique_id")
    private ProductCategory productCategory;
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
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
