package com.example.goty.services;

import com.example.goty.services.dto.ProductServiceResponse;

public interface ProductService{
    ProductServiceResponse findAll(String token);
}
