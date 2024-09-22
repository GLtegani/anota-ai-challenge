package com.devtegani.anota_ai_challenge.services;

import com.devtegani.anota_ai_challenge.entities.category.Category;
import com.devtegani.anota_ai_challenge.entities.category.CategoryDTO;
import com.devtegani.anota_ai_challenge.entities.category.exceptions.CategoryNotFoundException;
import com.devtegani.anota_ai_challenge.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
   @Autowired
   private CategoryRepository categoryRepository;

   public final Category insert(CategoryDTO categoryData) {
      Category newCategory = new Category(categoryData);
      this.categoryRepository.save(newCategory);
      return newCategory;
   }

   public final List<Category> getAll() {
      return this.categoryRepository.findAll();
   }

   public final Category update(String id, CategoryDTO categoryData) {
      Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);

      if(!categoryData.title().isEmpty()) {
         category.setTitle(categoryData.title());
      }

      if(!categoryData.description().isEmpty()) {
         category.setDescription(categoryData.description());
      }

      this.categoryRepository.save(category);
      return category;
   }

   public final void delete(String id) {
      Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
      this.categoryRepository.delete(category);
   }

   public final Optional<Category> getById(String id) {
      return this.categoryRepository.findById(id);
   }
}
