package com.example.ecommerce.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductDto {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String imageUrl;
    @NotNull
    private double price;
    @NotNull
    private String description;
    @NotNull
    private Integer categoryId;
}
