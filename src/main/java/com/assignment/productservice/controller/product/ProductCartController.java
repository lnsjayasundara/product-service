package com.assignment.productservice.controller.product;

import com.assignment.productservice.dto.product.PriceRequestDTO;
import com.assignment.productservice.product.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCartController {

    @Autowired
    private CartService cartService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/cart/getPrice")
    public ResponseEntity<Object> getTotalPrice(@RequestBody PriceRequestDTO priceRequest){
        try {
            Double totalPrice = cartService.calculatePrice(priceRequest);
            if (totalPrice != 0) {
                return new ResponseEntity(totalPrice, HttpStatus.OK);
            } else {
                return new ResponseEntity("Error", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("Error", HttpStatus.NOT_FOUND);
        }
    }
}
