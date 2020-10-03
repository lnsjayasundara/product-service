package com.assignment.productservice.controller.product;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.assignment.productservice.ProductServiceApplication;
import com.assignment.productservice.dto.product.PriceRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@SpringBootTest(classes = ProductServiceApplication.class)
@AutoConfigureMockMvc
public class ProductCartControllerTest {
    private PriceRequestDTO priceRequest;
    @Autowired
    private MockMvc mock;

    @BeforeEach
    public void intData() {
        priceRequest = new PriceRequestDTO();
        priceRequest.setId(1L);
        priceRequest.setUnitCount(1);
        priceRequest.setCartonCount(0);
    }

    @Test
    public void testGetTotalPrice() throws Exception{

        mock.perform(
                MockMvcRequestBuilders.post("/cart/getPrice").content(asJsonString(priceRequest))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetTotalPriceZero() throws Exception{
        priceRequest.setUnitCount(0);
        mock.perform(
                MockMvcRequestBuilders.post("/cart/getPrice").content(asJsonString(priceRequest))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
