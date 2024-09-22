package com.devtegani.anota_ai_challenge.services;

import com.devtegani.anota_ai_challenge.entities.category.Category;
import com.devtegani.anota_ai_challenge.entities.category.exceptions.CategoryNotFoundException;
import com.devtegani.anota_ai_challenge.entities.product.Product;
import com.devtegani.anota_ai_challenge.entities.product.ProductDTO;
import com.devtegani.anota_ai_challenge.entities.product.exceptions.ProductNotFoundException;
import com.devtegani.anota_ai_challenge.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
   @Autowired
   private ProductRepository productRepository;
   @Autowired
   private CategoryService categoryService;

   public final Product insert(ProductDTO productData) {
      Category category = this.categoryService.getById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);
      Product newProduct = new Product(productData);
      newProduct.setCategory(category);
      this.productRepository.save(newProduct);
      return newProduct;
   }

   public final List<Product> getAll() {
      return this.productRepository.findAll();
   }

   public final Product update(String id, ProductDTO productData) {
      Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

      if(productData.categoryId() != null) {
         this.categoryService.getById(productData.categoryId()).ifPresent(product::setCategory);
      }

      if(!productData.title().isEmpty()) {
         product.setTitle(productData.title());
      }

      if(!productData.description().isEmpty()) {
         product.setDescription(productData.description());
      }

      if(productData.price() != null) {
         product.setPrice(productData.price());
      }

      this.productRepository.save(product);
      return product;
   }

   public final void delete(String id) {
      Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
      this.productRepository.delete(product);
   }
}
