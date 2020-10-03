package com.assignment.productservice.controller.product;

import com.assignment.productservice.data.product.Product;
import com.assignment.productservice.dto.product.ProductDetailsDTO;
import com.assignment.productservice.product.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductDetailController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET, value= "/product/price/{id}")
    public ResponseEntity<Object> getProductPriceList(@PathVariable("id") Long id) {
        ProductDetailsDTO returnObj = (ProductDetailsDTO)productDetailsService.listProductPrice(id);
        System.out.println("returnObj >>>"+returnObj);
        if(returnObj == null || returnObj.getProductList().isEmpty()){
            return new ResponseEntity("Error", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(returnObj, HttpStatus.OK);
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET, value= "/product/list")
    public Object getProductList() {
        return productDetailsService.listProduct();
    }
}
