package com.ksero.productsmicroservice.services;

import com.ksero.productsmicroservice.domain.model.Product;
import com.ksero.productsmicroservice.domain.repositories.IProductRepository;
import com.ksero.productsmicroservice.domain.services.IProductService;
import com.ksero.productsmicroservice.shared.exception.InvalidResourceException;
import com.ksero.productsmicroservice.shared.exception.ResourceNotFoundException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService implements IProductService {

    private static final String entity = "Products";
    private final IProductRepository productRepository;
    private final Validator validator;

    public ProductService(IProductRepository productRepository, Validator validator) {
        this.productRepository = productRepository;
        // this.validator = validator;
        this.validator = validator;
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findByProductId(id).orElseThrow(() -> new ResourceNotFoundException(entity, id));
    }

    @Override
    public Product saveProduct(Product newProduct) {
        Set<ConstraintViolation<Product>> violations = validator.validate(newProduct);

        if (!violations.isEmpty()) {
            throw new InvalidResourceException(entity, violations);
        }

        Optional<Product> existingProduct = productRepository.findByProductId(newProduct.productId);
        if (existingProduct.isPresent()) {
            throw new InvalidResourceException("Product does not exist.");
        }

        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long productId, Product updateProduct) {
        Set<ConstraintViolation<Product>> violations = validator.validate(updateProduct);

        if (!violations.isEmpty()) {
            throw new InvalidResourceException(entity, violations);
        }

        Optional<Product> existingProduct = productRepository.findByProductId(productId);
        if (existingProduct.isEmpty()) {
            throw new InvalidResourceException("Product does not exist");
        }

        return productRepository.save(
                existingProduct.get()
                .withName(updateProduct.getName())
                .withPrice(updateProduct.getPrice())
                .withStock(updateProduct.getStock())
        );
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long productId) {
        Product existingProduct = productRepository.findByProductId(productId).orElseThrow(() -> new InvalidResourceException("Product does not exist"));
        productRepository.delete(existingProduct);
        return ResponseEntity.ok().build();
    }

}
