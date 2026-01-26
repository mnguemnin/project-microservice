package com.techie.microservice.product.repository;

import com.techie.microservice.product.model.Product;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.mongodb.repository.MongoRepository;
@Observed
public interface ProductRepository extends MongoRepository<Product, String> {
}