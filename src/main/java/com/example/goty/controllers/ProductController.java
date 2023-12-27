package com.example.goty.controllers;

import com.example.goty.services.ProductService;
import com.example.goty.services.dto.ProductServiceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductServiceResponse findAll(@RequestHeader( name = "x-token") String token) {
        return this.productService.findAll(token);
    }

}