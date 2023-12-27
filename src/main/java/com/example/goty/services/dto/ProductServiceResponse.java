package com.example.goty.services.dto;

import com.example.goty.models.ProductModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductServiceResponse {
    public String status;

    @JsonProperty("data")
    public List<ProductModel> products;
}

