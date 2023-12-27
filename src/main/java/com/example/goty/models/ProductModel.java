package com.example.goty.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductModel {

    private String id;
    private String name;
    private String url;
    private String price;
}
