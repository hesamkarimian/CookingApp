package com.sam.cookingapp.entitis;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 * @author HesamKarimian
 * @since 11/01/2022
 */
@Entity
@Table(name = "RECIPE_INGREDIENTS")
@Audited
public class RecipeIngredient {

  public RecipeIngredient() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "RECIPE_ID")
  private Recipe recipe;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "INGREDIENT_ID")
  private Ingredient ingredient;

  @Column
  private BigDecimal amount;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public Ingredient getIngredient() {
    return ingredient;
  }

  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
