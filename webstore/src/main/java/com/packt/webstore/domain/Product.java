package com.packt.webstore.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Przemek on 2016-08-25.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int productId;
    @Column(name = "NAME")
    private String productName;
    //private double productOldPrice;
    @Column(name = "PRICE")
    private double productPrice;
    @Column(name = "CATEGORY")
    private String productCategory;
    @Column(name = "DESCRPTION")
    private String productDescription;
    @Column(name = "AVAILABLE")
    private boolean productAvailable;
    @Column(name = "QUANTITY")
    private int productQuantity;
    @Column(name ="DATE")
    private Date date;

    public int getPrductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

//    public double getProductOldPrice() {
//        return productOldPrice;
//    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public boolean isProductAvailable() {
        return productAvailable;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setPrductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public void setProductOldPrice(double productOldPrice) {
//        this.productOldPrice = productOldPrice;
//    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
