package com.sam.cookingapp.dto;

import java.util.Set;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
public class IngredientDto {

  private Long id;
  private String name;
  private Set<RecipeIngredientDto> recipeIngredients;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<RecipeIngredientDto> getRecipeIngredients() {
    return recipeIngredients;
  }

  public void setRecipeIngredients(Set<RecipeIngredientDto> recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
  }
}
