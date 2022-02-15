package com.sam.cookingapp.entitis;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 * @author HesamKarimian
 * @since 03/01/2022
 */
@Entity
@Table(name = "INGREDIENTS")
@Audited
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column
  private String name;

  @OneToMany(mappedBy = "ingredient")
  private Set<RecipeIngredient> recipeIngredients;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<RecipeIngredient> getRecipeIngredients() {
    return recipeIngredients;
  }

  public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
  }
}
