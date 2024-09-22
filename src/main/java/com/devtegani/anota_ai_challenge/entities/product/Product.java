package com.devtegani.anota_ai_challenge.entities.product;

import com.devtegani.anota_ai_challenge.entities.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "products")
public class Product {
   @Id
   private String id;
   private String title;
   private String description;
   private String ownerId;
   private Integer price;
   private Category category;

   public Product(ProductDTO productData) {
      this.title = productData.title();
      this.description = productData.description();
      this.ownerId = productData.ownerId();
      this.price = productData.price();
   }
}
