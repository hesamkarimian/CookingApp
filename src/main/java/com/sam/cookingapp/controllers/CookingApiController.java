package com.sam.cookingapp.controllers;

import com.sam.cookingapp.dto.RecipeDto;
import com.sam.cookingapp.services.RecipeIngredientService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HesamKarimian
 * @since 26/01/2022
 */
@RestController
@RequestMapping("/api")
public class CookingApiController {

  private final RecipeIngredientService recipeIngredientService;

  public CookingApiController(RecipeIngredientService recipeIngredientService) {
    this.recipeIngredientService = recipeIngredientService;
  }

  @GetMapping("/recipe")
  public ResponseEntity<List<RecipeDto>> getAllRecipes() {
    return new ResponseEntity<>(recipeIngredientService.getAllRecipes(), HttpStatus.OK);
  }

  @GetMapping("/recipe/{id}")
  public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id) {
    return new ResponseEntity<>(recipeIngredientService.getById(id), HttpStatus.OK);
  }

  @PostMapping("/recipe")
  public ResponseEntity<RecipeDto> addRecipe(@RequestBody RecipeDto recipeDto) {
    RecipeDto recipeDtoResult = recipeIngredientService.addRecipe(recipeDto);
    return new ResponseEntity<>(recipeDtoResult, HttpStatus.CREATED);
  }

}
