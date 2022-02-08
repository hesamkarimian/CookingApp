package com.sam.cookingapp.advice;

import com.sam.cookingapp.exceptions.RecipeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author HesamKarimian
 * @since 28/01/2022
 */

@ControllerAdvice
public class RecipeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(RecipeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String recipeNotFoundHandler(RecipeNotFoundException ex) {
    return ex.getMessage();
  }
}
