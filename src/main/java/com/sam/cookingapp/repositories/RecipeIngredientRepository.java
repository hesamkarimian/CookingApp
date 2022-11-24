package com.sam.cookingapp.repositories;

import com.sam.cookingapp.entities.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}
