package com.practice.kafka_producer_practice.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.practice.kafka_producer_practice.config.ErrorMessage;
import com.practice.kafka_producer_practice.dto.CreateProductRestModel;
import com.practice.kafka_producer_practice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products") //http://localhost:<port>/products
public class ProductController {

    private final ProductService productService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody CreateProductRestModel product) {

        String productId;
        try{
            productId = productService.createProduct(product);
        } catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage(new Date(),e.getMessage(),"/products"));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }
}