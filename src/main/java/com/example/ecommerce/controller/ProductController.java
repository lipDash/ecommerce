package com.example.ecommerce.controller;

import com.example.ecommerce.common.ApiResponse;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.CategoryRepo;
import com.example.ecommerce.service.ProductService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@Data
public class ProductController {
    private final ProductService productService;
    private final CategoryRepo categoryRepo;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(false, "category isn't exist"), HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDto, optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true, "product has been created"), HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductDto productDto, @PathVariable int productId) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(false, "category isn't exist"), HttpStatus.BAD_REQUEST);
        }

        productService.updateProduct(productDto, productId);
        return new ResponseEntity<>(new ApiResponse(true, "product has been updated"), HttpStatus.CREATED);
    }
}
