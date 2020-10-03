package com.assignment.productservice.product.calculator;

import com.assignment.productservice.data.product.Product;
import org.springframework.stereotype.Component;

@Component
public class PriceCalculator {

    public Double calculatePrice(Product product,Integer unitCount, Integer cartonCount){
        Integer unitPerCarton = product.getUnitPerCarton();
        Double cartonPrice = product.getCartonPrice();
        Double total = calculateItemTotalPrice(unitCount,cartonPrice,unitPerCarton) + calculateCartonTotalPrice(cartonCount,cartonPrice);
        return total;
    }

    private Double calculateCartonTotalPrice(Integer noOfCarton, Double cartonPrice){
        Double total = 0.0;
        total = noOfCarton * cartonPrice;

        if (noOfCarton >= 3)
            total = total * 0.9;
        return total;
    }

    private Double calculateItemTotalPrice(Integer noOfUnit, Double cartonPrice, Integer unitPerCarton){
        Double total = 0.0;
        Double unitPrice = (cartonPrice/unitPerCarton) * 1.3;
        total = noOfUnit * unitPrice;

        return total;
    }

    public Integer calUnitCount(Product product,Integer unitCount){
        Integer unitPerCarton = product.getUnitPerCarton();
        return unitCount % unitPerCarton;
    }

    public Integer calCartonCount(Product product,Integer unitCount, Integer cartonCount){
        Integer unitPerCarton = product.getUnitPerCarton();
        return (unitCount/unitPerCarton) + cartonCount;
    }
}
