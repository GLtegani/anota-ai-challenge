package com.devtegani.anota_ai_challenge.repositories;

import com.devtegani.anota_ai_challenge.entities.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
