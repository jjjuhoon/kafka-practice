package com.practice.kafka_producer_practice.service;

import com.practice.kafka_producer_practice.dto.CreateProductRestModel;

public interface ProductService {
    String createProduct(CreateProductRestModel productRestModel)throws Exception;
}
