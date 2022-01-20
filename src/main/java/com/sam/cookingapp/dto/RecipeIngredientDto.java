package com.sam.cookingapp.dto;

import java.math.BigDecimal;
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
public class RecipeIngredientDto {

  private Long id;
  private RecipeDto recipe;
  private IngredientDto ingredient;
  private BigDecimal amount;
}
