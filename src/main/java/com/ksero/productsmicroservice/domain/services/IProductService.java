package com.ksero.productsmicroservice.domain.services;

import com.ksero.productsmicroservice.domain.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
    List<Product> listAll();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    Product updateProduct(Long productId, Product product);
    ResponseEntity<?> deleteProduct(Long productId);
}
