package com.devtegani.anota_ai_challenge.exceptions.exceptionHandler;

import com.devtegani.anota_ai_challenge.entities.category.exceptions.CategoryNotFoundException;
import com.devtegani.anota_ai_challenge.entities.product.exceptions.ProductNotFoundException;
import com.devtegani.anota_ai_challenge.exceptions.AnotaAiException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AnotaAiExceptionHandler {
   @ExceptionHandler(AnotaAiException.class)
   public final ProblemDetail handleAnotaAiException(AnotaAiException e) {
      return e.toProblemDetail();
   }

   @ExceptionHandler(CategoryNotFoundException.class)
   public final ProblemDetail handleCategoryNotFoundException(CategoryNotFoundException e) {
      return e.toProblemDetail();
   }

   @ExceptionHandler(ProductNotFoundException.class)
   public final ProblemDetail handleProductNotFoundException(ProductNotFoundException e) {
      return e.toProblemDetail();
   }
}
