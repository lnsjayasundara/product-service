package com.assignment.productservice.dto.product;

public class PriceRequestDTO {
    private Long id;
    private Integer unitCount;
    private Integer cartonCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    public Integer getCartonCount() {
        return cartonCount;
    }

    public void setCartonCount(Integer cartonCount) {
        this.cartonCount = cartonCount;
    }
}
