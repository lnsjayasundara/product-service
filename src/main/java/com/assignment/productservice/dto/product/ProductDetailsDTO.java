package com.assignment.productservice.dto.product;

import java.util.List;

public class ProductDetailsDTO {
    private List<ProductDTO> productList;

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
