package com.sam.cookingapp.mappers;

import com.sam.cookingapp.dto.RecipeDto;
import com.sam.cookingapp.entitis.Recipe;
import org.mapstruct.Mapper;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */
@Mapper
public interface RecipeMapper extends BasicMapper<Recipe, RecipeDto> {

  @Override
  RecipeDto toDto(Recipe entity);

  @Override
  Recipe toEntity(RecipeDto dto);
}
