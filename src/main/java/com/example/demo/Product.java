package com.example.demo;

public class Product {
    public String id;
    public String name_product;
    public String status;
    public String name_acronym;

    public Product(String id, String name_product, String status, String name_acronym) {
        this.id = id;
        this.name_product = name_product;
        this.status = status;
        this.name_acronym = name_acronym;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName_acronym() {
        return name_acronym;
    }

    public void setName_acronym(String name_acronym) {
        this.name_acronym = name_acronym;
    }
}
