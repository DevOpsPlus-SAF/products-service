package com.ksero.productsmicroservice.resources.show;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProductResource {
    @NotNull public Long productId;
    @NotNull public String name;
    @NotNull public Double price;
    @NotNull public Integer stock;
}
