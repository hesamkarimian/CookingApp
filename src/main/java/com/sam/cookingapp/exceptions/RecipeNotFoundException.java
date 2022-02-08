package com.sam.cookingapp.exceptions;

/**
 * @author HesamKarimian
 * @since 28/01/2022
 */
public class RecipeNotFoundException extends RuntimeException {

  public RecipeNotFoundException(Long id) {
    super("Could not find Recipe " + id);
  }
}
