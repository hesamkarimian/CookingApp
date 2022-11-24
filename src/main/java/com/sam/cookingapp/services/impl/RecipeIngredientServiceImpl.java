package com.sam.cookingapp.services.impl;

import com.sam.cookingapp.dto.IngredientDto;
import com.sam.cookingapp.dto.RecipeDto;
import com.sam.cookingapp.entities.Ingredient;
import com.sam.cookingapp.entities.Recipe;
import com.sam.cookingapp.exceptions.IngredientNotFoundException;
import com.sam.cookingapp.exceptions.RecipeNotFoundException;
import com.sam.cookingapp.mappers.CycleAvoidingMappingContext;
import com.sam.cookingapp.mappers.RecipeMapper;
import com.sam.cookingapp.repositories.IngredientRepository;
import com.sam.cookingapp.repositories.RecipeIngredientRepository;
import com.sam.cookingapp.repositories.RecipeRepository;
import com.sam.cookingapp.services.RecipeIngredientService;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
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
  private final IngredientRepository ingredientRepository;
  private final RecipeIngredientRepository recipeIngredientRepository;

  public RecipeIngredientServiceImpl(RecipeRepository recipeRepository,
                                     IngredientRepository ingredientRepository,
                                     RecipeIngredientRepository recipeIngredientRepository) {
    this.recipeRepository = recipeRepository;
    this.ingredientRepository = ingredientRepository;
    this.recipeIngredientRepository = recipeIngredientRepository;
  }

  @Override
  public List<RecipeDto> getAllRecipes() {
    return recipeRepository
      .findAll()
      .stream()
      .map(r -> RECIPE_MAPPER.toDto(r, new CycleAvoidingMappingContext()))
      .collect(Collectors.toList());
  }

  @Override
  public RecipeDto getById(Long id) {
    Recipe recipe = recipeRepository.findById(id)
                                    .orElseThrow(() -> new RecipeNotFoundException(id));
    return RECIPE_MAPPER.toDto(recipe, new CycleAvoidingMappingContext());
  }

  @Override
  @Transactional
  public RecipeDto addRecipe(RecipeDto dto) {
    Recipe recipe = RECIPE_MAPPER.toEntity(dto, new CycleAvoidingMappingContext());
    recipeRepository.save(recipe);
    try {
      if (recipe.getRecipeIngredients() != null && !recipe.getRecipeIngredients().isEmpty()) {
        recipe.getRecipeIngredients().forEach(ri -> {
          if (BigDecimal.ZERO.compareTo(ri.getAmount()) < 0) {
            Ingredient ingredient;
            if (ri.getIngredient().getId() == null) {
              ingredient = ingredientRepository.save(ri.getIngredient());
            } else {
              Optional<Ingredient> ingredientOptional = ingredientRepository.findById(ri.getIngredient().getId());
              if (ingredientOptional.isPresent()) {
                ingredient = ingredientOptional.get();
              } else {
                throw new IngredientNotFoundException(ri.getIngredient().getId());
              }
            }
            ri.setIngredient(ingredient);
            ri.setRecipe(recipe);
            recipeIngredientRepository.save(ri);
          }
        });
      }
    } catch (NullPointerException e) {
      throw new InvalidParameterException(e.getMessage());
    }

    return RECIPE_MAPPER.toDto(recipe, new CycleAvoidingMappingContext());
  }

  @Override
  public List<IngredientDto> getRecipeIngredient(RecipeDto dto) {
    return null;
  }
}
