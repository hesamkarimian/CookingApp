package com.sam.cookingapp.services.impl;

import com.sam.cookingapp.dto.IngredientDto;
import com.sam.cookingapp.dto.RecipeDto;
import com.sam.cookingapp.entitis.Recipe;
import com.sam.cookingapp.exceptions.RecipeNotFoundException;
import com.sam.cookingapp.mappers.CycleAvoidingMappingContext;
import com.sam.cookingapp.mappers.RecipeMapper;
import com.sam.cookingapp.repositories.RecipeIngredientRepository;
import com.sam.cookingapp.repositories.RecipeRepository;
import com.sam.cookingapp.services.RecipeIngredientService;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

  private static final RecipeMapper RECIPE_MAPPER = Mappers.getMapper(RecipeMapper.class);
  private final RecipeRepository recipeRepository;
  private final RecipeIngredientRepository recipeIngredientRepository;

  public RecipeIngredientServiceImpl(RecipeRepository recipeRepository,
                                     RecipeIngredientRepository recipeIngredientRepository) {
    this.recipeRepository = recipeRepository;
    this.recipeIngredientRepository = recipeIngredientRepository;
  }

  @Override
  public List<RecipeDto> getAllRecipes() {
    return recipeRepository
      .findAll()
      .stream()
      .map(r->RECIPE_MAPPER.toDto(r, new CycleAvoidingMappingContext()))
      .collect(Collectors.toList());
  }

  @Override
  public RecipeDto getById(Long id) {
    Recipe recipe = recipeRepository.findById(id)
                                    .orElseThrow(() -> new RecipeNotFoundException(id));
    return RECIPE_MAPPER.toDto(recipe, new CycleAvoidingMappingContext());
  }

  @Override
  public RecipeDto addRecipe(RecipeDto dto) {
    Recipe recipe = RECIPE_MAPPER.toEntity(dto, new CycleAvoidingMappingContext());
    recipeRepository.save(recipe);

    return RECIPE_MAPPER.toDto(recipe, new CycleAvoidingMappingContext());
  }

  @Override
  public List<IngredientDto> getRecipeIngredient(RecipeDto dto) {
    return null;
  }
}
