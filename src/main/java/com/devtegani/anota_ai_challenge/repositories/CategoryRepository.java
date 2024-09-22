package com.devtegani.anota_ai_challenge.repositories;

import com.devtegani.anota_ai_challenge.entities.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
