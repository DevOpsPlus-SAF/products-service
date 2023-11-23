package com.ksero.productsmicroservice.domain.repositories;

import com.ksero.productsmicroservice.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findByProductId(Long productId);
}
