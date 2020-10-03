package com.assignment.productservice.product.service.impl;

import com.assignment.productservice.data.product.Product;
import com.assignment.productservice.dto.product.PriceRequestDTO;
import com.assignment.productservice.product.calculator.PriceCalculator;
import com.assignment.productservice.product.repository.ProductRepository;
import com.assignment.productservice.product.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceCalculator priceCalculator;

    @Override
    public Double calculatePrice(PriceRequestDTO priceRequestDTO) {
        Optional<Product> productOpt = productRepository.findById(priceRequestDTO.getId());
        if(productOpt.isPresent()) {
            Product product = productOpt.get();
            Integer unitCout = priceCalculator.calUnitCount(product, priceRequestDTO.getUnitCount());
            Integer cartonCount = priceCalculator.calCartonCount(product,priceRequestDTO.getUnitCount(),priceRequestDTO.getCartonCount());
            return priceCalculator.calculatePrice(productOpt.get(), unitCout, cartonCount);
        }
        return 0.0;
    }
}
