package com.example.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String imageUrl;
    @NotNull
    private double price;
    @NotNull
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
