package com.sam.cookingapp.mappers;

import com.sam.cookingapp.dto.RecipeDto;
import com.sam.cookingapp.entities.Recipe;
import org.mapstruct.Mapper;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */
@Mapper(componentModel = "spring")
public interface RecipeMapper extends BasicMapper<Recipe, RecipeDto> {

}
