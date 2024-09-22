package com.devtegani.anota_ai_challenge.controllers;

import com.devtegani.anota_ai_challenge.entities.product.Product;
import com.devtegani.anota_ai_challenge.entities.product.ProductDTO;
import com.devtegani.anota_ai_challenge.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
   @Autowired
   private ProductService productService;

   @PostMapping
   public final ResponseEntity<Product> insert(@RequestBody ProductDTO productData) {
      Product newProduct = this.productService.insert(productData);
      return ResponseEntity.created(URI.create("/api/categories")).body(newProduct);
   }

   @GetMapping
   public final ResponseEntity<List<Product>> getAll() {
      List<Product> products = this.productService.getAll();
      return ResponseEntity.ok(products);
   }

   @PutMapping("/{id}")
   public final ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productData) {
      Product updatedProduct = this.productService.update(id, productData);
      return ResponseEntity.ok(updatedProduct);
   }

   @DeleteMapping("/{id}")
   public final ResponseEntity<Product> delete(@PathVariable("id") String id) {
      this.productService.delete(id);
      return ResponseEntity.noContent().build();
   }
}
