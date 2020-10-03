package com.assignment.productservice.dto.product;

public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private int totalUnit;
    private int noOfCarton;
    private int noOfUnit;

    public Long getId() {return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalUnit() {
        return totalUnit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalUnit(int totalUnit) {
        this.totalUnit = totalUnit;
    }

    public int getNoOfCarton() {
        return noOfCarton;
    }

    public void setNoOfCarton(int noOfCarton) {
        this.noOfCarton = noOfCarton;
    }

    public int getNoOfUnit() {
        return noOfUnit;
    }

    public void setNoOfUnit(int noOfUnit) {
        this.noOfUnit = noOfUnit;
    }
}
