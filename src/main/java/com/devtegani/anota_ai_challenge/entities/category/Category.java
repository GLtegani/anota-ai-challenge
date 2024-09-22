package com.devtegani.anota_ai_challenge.entities.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "categories")
public class Category {
   @Id
   private String id;
   private String title;
   private String description;
   private String ownerId;

   public Category(CategoryDTO categoryData) {
      this.title = categoryData.title();
      this.description = categoryData.description();
      this.ownerId = categoryData.ownerId();
   }
}
