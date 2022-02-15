package com.sam.cookingapp.mappers;

import com.sam.cookingapp.dto.RecipeIngredientDto;
import com.sam.cookingapp.entitis.RecipeIngredient;
import org.mapstruct.Mapper;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */

@Mapper(componentModel = "spring")
public interface RecipeIngredientMapper extends BasicMapper<RecipeIngredient, RecipeIngredientDto>{

}
