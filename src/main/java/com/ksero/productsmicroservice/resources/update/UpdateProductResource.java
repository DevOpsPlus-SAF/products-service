package com.ksero.productsmicroservice.resources.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResource {
    @JsonIgnore
    public Long productId;
    @NotBlank
    @NotNull
    @JsonProperty("name") public String name;
    @NotBlank @NotNull @JsonProperty("price") public double price;
    @NotBlank @NotNull @JsonProperty("stock") public int stock;
}
