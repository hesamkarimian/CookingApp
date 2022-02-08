package com.sam.cookingapp.dto;

import java.util.Set;
import lombok.Data;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
@Data
public class IngredientDto {

  private Long id;
  private String name;
  private Set<RecipeIngredientDto> recipeIngredients;
}
