package com.devtegani.anota_ai_challenge.entities.category.exceptions;

import com.devtegani.anota_ai_challenge.exceptions.AnotaAiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CategoryNotFoundException extends AnotaAiException {
   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

      problemDetail.setTitle("Category not found");

      return problemDetail;
   }
}
