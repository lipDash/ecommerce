package com.example.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String categoryName;
    @NotBlank
    private String description;
    @NotBlank
    private String imageUrl;
}
