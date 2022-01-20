package com.sam.cookingapp.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeDto {

  private Long id;
  private String name;
  private String sourceCountry;
  private String imageUrl;
  private String description;

  private Set<RecipeIngredientDto> recipeIngredients;


}
