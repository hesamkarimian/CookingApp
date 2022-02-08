package com.sam.cookingapp.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
@Data
public class RecipeIngredientDto {

  private Long id;
  private RecipeDto recipe;
  private IngredientDto ingredient;
  private BigDecimal amount;
}
