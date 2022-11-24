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
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

/**
 * @author HesamKarimian
 * @since 08/02/2022
 */
public class RecipeMapperTest {

  private RecipeMapper recipeMapper = Mappers.getMapper(RecipeMapper.class);

  private Recipe recipe;
  private RecipeDto recipeDto;

  @Before
  public void init() {

  }

  private void initializeRecipeDto() {
    this.recipeDto = new RecipeDto();

    this.recipeDto.setId(100L);
    this.recipeDto.setDescription("A tasty dish from Iran");
    this.recipeDto.setImageUrl("My Sample Test recipe URL");
    this.recipeDto.setName("Kash Bademjan");
    this.recipeDto.setSourceCountry("Iran");

    RecipeIngredientDto recipeIngredientDto = new RecipeIngredientDto();
    recipeIngredientDto.setRecipe(this.recipeDto);
    recipeIngredientDto.setIngredient(new IngredientDto());
    recipeIngredientDto.setId(1L);
    recipeIngredientDto.setAmount(new BigDecimal(111));

    RecipeIngredientDto recipeIngredientDto2 = new RecipeIngredientDto();
    recipeIngredientDto2.setRecipe(this.recipeDto);
    recipeIngredientDto2.setIngredient(new IngredientDto());
    recipeIngredientDto2.setId(2L);
    recipeIngredientDto2.setAmount(new BigDecimal(222));

    this.recipeDto.setRecipeIngredients(Set.of(recipeIngredientDto, recipeIngredientDto2));
  }

  private void initializeRecipeEntity() {
    this.recipe = new Recipe();
    this.recipe.setId(100L);
    this.recipe.setDescription("A tasty dish from Iran");
    this.recipe.setImageUrl("My Sample Test recipe URL");
    this.recipe.setName("Kash Bademjan");
    this.recipe.setSourceCountry("Iran");

    RecipeIngredient recipeIngredient = new RecipeIngredient();
    recipeIngredient.setRecipe(this.recipe);
    recipeIngredient.setIngredient(new Ingredient());
    recipeIngredient.setId(1L);
    recipeIngredient.setAmount(new BigDecimal(111));

    RecipeIngredient recipeIngredient2 = new RecipeIngredient();
    recipeIngredient2.setRecipe(this.recipe);
    recipeIngredient2.setIngredient(new Ingredient());
    recipeIngredient2.setId(2L);
    recipeIngredient2.setAmount(new BigDecimal(222));

    this.recipe.setRecipeIngredients(Set.of(recipeIngredient, recipeIngredient2));
  }

  @Test
  public void given_recipe_whenMappingToDto_thenShouldReturnRecipeDto() {
    // Given
    initializeRecipeEntity();

    // When
    RecipeDto recipeDto = recipeMapper.toDto(this.recipe, new CycleAvoidingMappingContext());

    // Then
    assertThat(recipeDto.getId()).isEqualTo(recipe.getId());
    assertThat(recipeDto.getDescription()).isEqualTo(recipe.getDescription());
    assertThat(recipeDto.getImageUrl()).isEqualTo(recipe.getImageUrl());
    assertThat(recipeDto.getName()).isEqualTo(recipe.getName());
    assertThat(recipeDto.getSourceCountry()).isEqualTo(recipe.getSourceCountry());

    Set<RecipeIngredientDto> recipeIngredientDtos = recipeDto.getRecipeIngredients();
    assertThat(recipeIngredientDtos.size()).isEqualTo(2);
    assertThat(recipeIngredientDtos).extracting("recipe").containsExactly(recipeDto, recipeDto);
    assertThat(recipeIngredientDtos).extracting("id").contains(1L, 2L);
    assertThat(recipeIngredientDtos).extracting("amount").contains(new BigDecimal(111), new BigDecimal(222));

    recipeDto.getRecipeIngredients().forEach(rid -> {
      assertThat(this.recipe.getRecipeIngredients().stream().filter(ri -> rid.getId().equals(ri.getId())
        && rid.getAmount().equals(ri.getAmount())).count()).isEqualTo(1L);
    });

  }

  @Test
  public void given_recipeDto_whenMappingToEntity_thenShouldReturnRecipe() {
    // Given this.recipeDto
    initializeRecipeDto();

    // When
    Recipe recipe = recipeMapper.toEntity(this.recipeDto, new CycleAvoidingMappingContext());

    // Then
    assertThat(recipe.getDescription()).isEqualTo(this.recipeDto.getDescription());
    assertThat(recipe.getId()).isEqualTo(this.recipeDto.getId());
    assertThat(recipe.getName()).isEqualTo(this.recipeDto.getName());
    assertThat(recipe.getImageUrl()).isEqualTo(this.recipeDto.getImageUrl());
    assertThat(recipe.getSourceCountry()).isEqualTo(this.recipeDto.getSourceCountry());

    Set<RecipeIngredient> recipeIngredients = recipe.getRecipeIngredients();
    assertThat(recipeIngredients.size()).isEqualTo(2);

    assertThat(recipeIngredients).extracting("recipe").containsExactly(recipe, recipe);
    assertThat(recipeIngredients).extracting("id").contains(1L, 2L);
    assertThat(recipeIngredients).extracting("amount").contains(new BigDecimal(111), new BigDecimal(222));

    recipe.getRecipeIngredients().forEach(ri -> {
      assertThat(this.recipeDto.getRecipeIngredients().stream().filter(rid -> ri.getId().equals(rid.getId())
        && ri.getAmount().equals(rid.getAmount())).count()).isEqualTo(1L);
    });
  }
}
