package com.sam.cookingapp.repositories;

import com.sam.cookingapp.entitis.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HesamKarimian
 * @since 19/01/2022
 */
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
