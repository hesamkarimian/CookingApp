package com.sam.cookingapp.services;

import com.sam.cookingapp.dto.IngredientDto;
import com.sam.cookingapp.dto.RecipeDto;
import java.util.List;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
public interface RecipeIngredientService {

  List<RecipeDto> getAllRecipes();

  List<IngredientDto> getRecipeIngredient(RecipeDto dto);

  RecipeDto getById(Long id);

  RecipeDto addRecipe(RecipeDto dto);
}
