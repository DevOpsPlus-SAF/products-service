package com.ksero.productsmicroservice.shared.configuration.sample;

import com.ksero.productsmicroservice.domain.model.Product;
import com.ksero.productsmicroservice.domain.repositories.IProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final IProductRepository productRepository;

    public DatabaseInitializer(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setProductsData() {
        long quantity = productRepository.count();
        if (quantity == 0) {
            List<Product> defaultProducts = new ArrayList<Product>();
            defaultProducts.add(new Product(1L, "Gaseosa Inca Kola 500ml", 8.6, 3));
            defaultProducts.add(new Product(2L, "Gaseosa Cnca Kola 500ml", 8.6, 12));
            defaultProducts.add(new Product(3L, "Gaseosa Sprite 500ml", 8.1, 3));
            productRepository.saveAll(defaultProducts);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        setProductsData();
    }
}
