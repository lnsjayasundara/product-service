package com.assignment.productservice.product.service.impl;

import com.assignment.productservice.data.product.Product;
import com.assignment.productservice.dto.product.ProductDTO;
import com.assignment.productservice.dto.product.ProductDetailsDTO;
import com.assignment.productservice.product.calculator.PriceCalculator;
import com.assignment.productservice.product.repository.ProductRepository;
import com.assignment.productservice.product.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceCalculator priceCalculator;

    @Override
    public ProductDetailsDTO listProductPrice(Long id) {
        ArrayList productDTOList = new ArrayList();
        Optional<Product> productOpt = productRepository.findById(id);

        if(productOpt.isPresent()) {
            Product product = productOpt.get();
            for (int i = 1; i <= 50; i++) {
                ProductDTO productDTO = new ProductDTO();
                Integer unitCout = priceCalculator.calUnitCount(product, i);
                Integer cartonCount = priceCalculator.calCartonCount(product,i,0);
                productDTO.setPrice(priceCalculator.calculatePrice(product,unitCout,cartonCount));
                productDTO.setName(product.getName());
                productDTO.setNoOfCarton(cartonCount);
                productDTO.setNoOfUnit(unitCout);
                productDTO.setTotalUnit(i);
                productDTOList.add(productDTO);
            }
        }

        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        productDetailsDTO.setProductList(productDTOList);
        return productDetailsDTO;
    }

    @Override
    public ProductDetailsDTO listProduct() {
        ArrayList productDTOList = new ArrayList();
        Iterable<Product> products = productRepository.findAll();
        products.forEach(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(priceCalculator.calculatePrice(product,1,0));
            productDTO.setNoOfCarton(0);
            productDTO.setNoOfUnit(1);
            productDTO.setTotalUnit(1);
            productDTOList.add(productDTO);
        });
        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        productDetailsDTO.setProductList(productDTOList);
        return productDetailsDTO;
    }

}
