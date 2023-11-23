package com.ksero.productsmicroservice.mapping;

import com.ksero.productsmicroservice.domain.model.Product;
import com.ksero.productsmicroservice.resources.create.CreateProductResource;
import com.ksero.productsmicroservice.resources.show.ProductResource;
import com.ksero.productsmicroservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ProductMapper implements Serializable {

    @Autowired
    EnhancedModelMapper enhancedModelMapper;

    public ProductResource toResource(Product modelProduct) {
        return enhancedModelMapper.map(modelProduct, ProductResource.class);
    }

    public <Resource> Product toModel(Resource resourceProduct) {
        return enhancedModelMapper.map(resourceProduct, Product.class);
    }

    public List<ProductResource> toListResource(List<Product> modelProducts) {
        return enhancedModelMapper.mapList(modelProducts, ProductResource.class);
    }
}
