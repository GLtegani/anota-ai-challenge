package com.devtegani.anota_ai_challenge.entities.product.exceptions;

import com.devtegani.anota_ai_challenge.exceptions.AnotaAiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProductNotFoundException extends AnotaAiException {
   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

      problemDetail.setTitle("Product not found");

      return problemDetail;
   }
}
