package com.ksero.productsmicroservice.resources.create;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
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
public class CreateProductResource {
  @JsonIgnore public Long productId;
  @NotBlank @NotNull @JsonProperty("name") public String name;
  @NotBlank @NotNull @JsonProperty("price") public double price;
  @NotBlank @NotNull @JsonProperty("stock") public int stock;
}
