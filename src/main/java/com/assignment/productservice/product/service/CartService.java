package com.assignment.productservice.product.service;

import com.assignment.productservice.dto.product.PriceRequestDTO;


public interface CartService {
    Double calculatePrice(PriceRequestDTO priceRequestDTO);
}
