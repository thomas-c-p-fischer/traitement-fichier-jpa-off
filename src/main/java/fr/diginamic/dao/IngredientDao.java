/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entities.Ingredient;

/** Dao pour l'entité Ingredient **/
public interface IngredientDao {
	void insert(Ingredient ingredient);
	boolean existe(String nom);
}
