package com.assignment.productservice.product.repository;

import com.assignment.productservice.data.product.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
