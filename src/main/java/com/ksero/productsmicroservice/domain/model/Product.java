package com.ksero.productsmicroservice.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long productId;
    public String name;
    public Double price;
    public Integer stock;
}
