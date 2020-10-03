package com.assignment.productservice.product.service;

import com.assignment.productservice.dto.product.ProductDetailsDTO;

import java.util.List;

public interface ProductDetailsService {
    ProductDetailsDTO listProductPrice(Long id);
    ProductDetailsDTO listProduct();
}
