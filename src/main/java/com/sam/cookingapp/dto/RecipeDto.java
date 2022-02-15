package com.sam.cookingapp.dto;

import java.util.Set;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
public class RecipeDto {

  public RecipeDto() {
  }

  private Long id;
  private String name;
  private String sourceCountry;
  private String imageUrl;
  private String description;
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

  public String getSourceCountry() {
    return sourceCountry;
  }

  public void setSourceCountry(String sourceCountry) {
    this.sourceCountry = sourceCountry;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<RecipeIngredientDto> getRecipeIngredients() {
    return recipeIngredients;
  }

  public void setRecipeIngredients(Set<RecipeIngredientDto> recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
  }
}
