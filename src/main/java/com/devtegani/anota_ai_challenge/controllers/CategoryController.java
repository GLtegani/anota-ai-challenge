package com.devtegani.anota_ai_challenge.controllers;

import com.devtegani.anota_ai_challenge.entities.category.Category;
import com.devtegani.anota_ai_challenge.entities.category.CategoryDTO;
import com.devtegani.anota_ai_challenge.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
   @Autowired
   private CategoryService categoryService;

   @PostMapping
   public final ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData) {
      Category newCategory = this.categoryService.insert(categoryData);
      return ResponseEntity.created(URI.create("/api/categories")).body(newCategory);
   }

   @GetMapping
   public final ResponseEntity<List<Category>> getAll() {
      List<Category> categories = this.categoryService.getAll();
      return ResponseEntity.ok(categories);
   }

   @PutMapping("/{id}")
   public final ResponseEntity<Category> update(@PathVariable("id") String id, @RequestBody CategoryDTO categoryData) {
      Category updatedCategory = this.categoryService.update(id, categoryData);
      return ResponseEntity.ok(updatedCategory);
   }

   @DeleteMapping("/{id}")
   public final ResponseEntity<Category> delete(@PathVariable("id") String id) {
      this.categoryService.delete(id);
      return ResponseEntity.noContent().build();
   }
}
