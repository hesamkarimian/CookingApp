package com.sam.cookingapp.exceptions;

/**
 * @author HesamKarimian
 * @since 01/03/2022
 */
public class IngredientNotFoundException extends RuntimeException {

  public IngredientNotFoundException(Long id) {
    super("Could not find Ingredient " + id);
  }

}
