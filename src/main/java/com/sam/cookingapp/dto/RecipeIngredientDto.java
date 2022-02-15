package com.sam.cookingapp.dto;

import java.math.BigDecimal;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
public class RecipeIngredientDto {

  private Long id;
  private RecipeDto recipe;
  private IngredientDto ingredient;
  private BigDecimal amount;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RecipeDto getRecipe() {
    return recipe;
  }

  public void setRecipe(RecipeDto recipe) {
    this.recipe = recipe;
  }

  public IngredientDto getIngredient() {
    return ingredient;
  }

  public void setIngredient(IngredientDto ingredient) {
    this.ingredient = ingredient;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
