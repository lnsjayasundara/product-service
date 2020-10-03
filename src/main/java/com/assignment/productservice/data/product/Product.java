package com.assignment.productservice.data.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="unit_per_carton")
    private Integer unitPerCarton;

    @Column(name="carton_price")
    private Double cartonPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUnitPerCarton() {
        return unitPerCarton;
    }

    public void setUnitPerCarton(Integer unitPerCarton) {
        this.unitPerCarton = unitPerCarton;
    }

    public Double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(Double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }
}
