package com.example.goty.services;

import com.example.goty.services.dto.ProductServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ProductServiceImplementation extends AbstractClient implements ProductService {

    public ProductServiceImplementation(RestTemplate restTemplate) {
        super(restTemplate);
    }
    Logger logger = LoggerFactory.getLogger(ProductServiceImplementation.class);
    @Override
    public ProductServiceResponse findAll(String token) {
        String uri = baseUrl + "/products";
        HttpEntity<Void> requestEntity = new HttpEntity<>(this.buildAuthToken(token));
        ResponseEntity<ProductServiceResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , ProductServiceResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
             logger.info(response.getBody().getStatus());
            return response.getBody();
        }
        logger.error("Error in user creation - httpStatus was: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }
}
