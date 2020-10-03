package com.assignment.productservice.controller.product;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.assignment.productservice.ProductServiceApplication;
import com.assignment.productservice.dto.product.ProductDTO;
import com.assignment.productservice.dto.product.ProductDetailsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(classes = ProductServiceApplication.class)
@AutoConfigureMockMvc
public class ProductDetailControllerTest {

    @Autowired
    private MockMvc mock;

    @Test
    public void testGetProductPriceList() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/product/price/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productList").isNotEmpty());
    }

    @Test
    public void testGetProductPriceListNotFound() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/product/price/{id}", 0).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
    }

    @Test
    public void testGetProductList() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/product/list").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productList").isNotEmpty());
    }
}
