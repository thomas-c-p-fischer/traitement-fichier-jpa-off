package fr.diginamic.dao;

import java.util.List;
import java.util.Set;

import fr.diginamic.entities.Produit;

/** Dao pour l'entité Produit */
public interface ProduitDao {
	void insert(Produit produit, String nomCategorie, String nomMarque, Set<String> nomsIngredients,
			Set<String> nomsAdditifs, Set<String> nomsAllergenes);
	boolean existe(String nom);
}