package com.sam.cookingapp.mappers;

import com.sam.cookingapp.dto.RecipeDto;
import com.sam.cookingapp.dto.RecipeIngredientDto;
import com.sam.cookingapp.entitis.Recipe;
import com.sam.cookingapp.entitis.RecipeIngredient;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */
@Mapper(componentModel = "spring")
public interface RecipeMapper extends BasicMapper<Recipe, RecipeDto> {

}
