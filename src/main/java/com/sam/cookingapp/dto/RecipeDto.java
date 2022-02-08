package com.sam.cookingapp.dto;

import java.util.Set;
import lombok.Data;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
@Data
public class RecipeDto {

  private Long id;
  private String name;
  private String sourceCountry;
  private String imageUrl;
  private String description;

  private Set<RecipeIngredientDto> recipeIngredients;

}
