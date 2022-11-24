package com.sam.cookingapp.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import com.sam.cookingapp.dto.IngredientDto;
import com.sam.cookingapp.dto.RecipeDto;
import com.sam.cookingapp.dto.RecipeIngredientDto;
import com.sam.cookingapp.entities.Ingredient;
import com.sam.cookingapp.entities.Recipe;
import com.sam.cookingapp.entities.RecipeIngredient;
import java.math.BigDecimal;
import java.util.Set;
import org.junit.Test;

/**
 * @author HesamKarimian
 * @since 15/02/2022
 */
public class IngredientMapperTest {

  private IngredientMapper ingredientMapper = new IngredientMapperImpl();

  private Ingredient ingredient;
  private IngredientDto ingredientDto;

  private void initializeIngredientDto() {
    ingredientDto = new IngredientDto();
    ingredientDto.setId(100L);
    ingredientDto.setName("meat");

    RecipeIngredientDto recipeIngredientDto = new RecipeIngredientDto();
    recipeIngredientDto.setRecipe(new RecipeDto());
    recipeIngredientDto.setIngredient(ingredientDto);
    recipeIngredientDto.setId(1L);
    recipeIngredientDto.setAmount(new BigDecimal(111));

    RecipeIngredientDto recipeIngredientDto2 = new RecipeIngredientDto();
    recipeIngredientDto2.setRecipe(new RecipeDto());
    recipeIngredientDto2.setIngredient(ingredientDto);
    recipeIngredientDto2.setId(2L);
    recipeIngredientDto2.setAmount(new BigDecimal(222));
    this.ingredientDto.setRecipeIngredients(Set.of(recipeIngredientDto, recipeIngredientDto2));
  }

  private void initializeIngredient() {
    this.ingredient = new Ingredient();
    this.ingredient.setId(100L);
    this.ingredient.setName("meat");

    RecipeIngredient recipeIngredient = new RecipeIngredient();
    recipeIngredient.setRecipe(new Recipe());
    recipeIngredient.setIngredient(this.ingredient);
    recipeIngredient.setId(1L);
    recipeIngredient.setAmount(new BigDecimal(111));

    RecipeIngredient recipeIngredient2 = new RecipeIngredient();
    recipeIngredient2.setRecipe(new Recipe());
    recipeIngredient2.setIngredient(this.ingredient);
    recipeIngredient2.setId(2L);
    recipeIngredient2.setAmount(new BigDecimal(222));
    this.ingredient.setRecipeIngredients(Set.of(recipeIngredient, recipeIngredient2));
  }

  @Test
  public void Given_IngredientDto_When_MappingToEntity_Then_ShouldReturnIngredient() {
    // Given this.IngredientDto
    initializeIngredientDto();

    // When
    Ingredient ingredient = ingredientMapper.toEntity(this.ingredientDto, new CycleAvoidingMappingContext());

    // Then
    assertThat(ingredient.getId()).isEqualTo(this.ingredientDto.getId());
    assertThat(ingredient.getName()).isEqualTo(this.ingredientDto.getName());

    Set<RecipeIngredient> recipeIngredients = ingredient.getRecipeIngredients();
    assertThat(recipeIngredients.size()).isEqualTo(2);
    assertThat(recipeIngredients).extracting("ingredient").containsExactly(ingredient, ingredient);
    assertThat(recipeIngredients).extracting("amount").contains(new BigDecimal(111), new BigDecimal(222));

    ingredient.getRecipeIngredients().forEach(ri -> {
      assertThat(this.ingredientDto.getRecipeIngredients().stream().filter(rid -> rid.getId().equals(ri.getId()) &&
        rid.getAmount().equals(ri.getAmount())).count()).isEqualTo(1L);
    });
  }

  @Test
  public void Given_IngredientEntity_When_MappingToDto_Then_ShouldReturnIngredientDto() {
    // Given this.Ingredient
    initializeIngredient();

    // When
    IngredientDto ingredientDto = ingredientMapper.toDto(this.ingredient, new CycleAvoidingMappingContext());

    // Then
    assertThat(ingredientDto.getName()).isEqualTo(this.ingredient.getName());
    assertThat(ingredientDto.getId()).isEqualTo(this.ingredient.getId());

    Set<RecipeIngredientDto> recipeIngredientDtos = ingredientDto.getRecipeIngredients();

    assertThat(recipeIngredientDtos.size()).isEqualTo(2);
    assertThat(recipeIngredientDtos).extracting("ingredient").containsExactly(ingredientDto, ingredientDto);
    assertThat(recipeIngredientDtos).extracting("amount").contains(new BigDecimal(111), new BigDecimal(222));
  }

}
