package com.ksero.productsmicroservice.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksero.productsmicroservice.domain.model.Product;
import com.ksero.productsmicroservice.domain.services.IProductService;
import com.ksero.productsmicroservice.mapping.ProductMapper;
import com.ksero.productsmicroservice.resources.create.CreateProductResource;
import com.ksero.productsmicroservice.resources.show.ProductResource;

import com.ksero.productsmicroservice.resources.update.UpdateProductResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v0/products", produces = "application/json")
@Tag(name = "Product", description = "Microservice CRUD for Products ✔")
public class ProductController {
    private final IProductService productService;
    private final ProductMapper productMapper;

    public ProductController(IProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("all")
    public List<ProductResource> getAllSkills() {
        return productMapper.toListResource(productService.listAll());
    }

    @GetMapping("get/id={id}")
    public ProductResource getProductById(@PathVariable Long id) {
        return productMapper.toResource(productService.getProductById(id));
    }

    @PostMapping("create")
    public ProductResource postProduct(@RequestBody CreateProductResource createProductResource) {
      return productMapper.toResource(productService.saveProduct(productMapper.toModel(createProductResource)));
    }

    @PutMapping("update/id={id}")
    public ProductResource putProduct(@PathVariable Long id, @RequestBody UpdateProductResource updateProductResource) {
        return productMapper.toResource(productService.updateProduct(id, productMapper.toModel(updateProductResource)));
    }

    @DeleteMapping("delete/id={id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

}
