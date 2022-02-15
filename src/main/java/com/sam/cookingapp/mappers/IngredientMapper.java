package com.sam.cookingapp.mappers;

import com.sam.cookingapp.dto.IngredientDto;
import com.sam.cookingapp.entitis.Ingredient;
import org.mapstruct.Mapper;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */

@Mapper(componentModel = "spring")
public interface IngredientMapper extends BasicMapper<Ingredient, IngredientDto> {

}
