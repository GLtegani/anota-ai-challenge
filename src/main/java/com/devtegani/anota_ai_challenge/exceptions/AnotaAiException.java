package com.devtegani.anota_ai_challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class AnotaAiException extends RuntimeException{
   public ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

      problemDetail.setTitle("Anota Ai internal server error");

      return problemDetail;
   }
}
