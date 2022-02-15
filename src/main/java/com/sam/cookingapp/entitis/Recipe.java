package com.sam.cookingapp.entitis;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.envers.Audited;

/**
 * @author HesamKarimian
 * @since 03/01/2022
 */

@Entity
@Table(name = "RECIPES")
@Data
@Audited
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column
  private String name;
  @Column
  private String sourceCountry;
  @Column
  private String imageUrl;
  @Column
  private String description;

  @OneToMany(mappedBy = "recipe")
  private Set<RecipeIngredient> recipeIngredients;

}
