package fr.diginamic.dao;

import fr.diginamic.entities.Produit;
import fr.diginamic.entities.ValeurNutritionnelle;

/** Dao pour l'entité ValeurNutritionnelle */
public interface ValeurNutritionnelleDao {
	void insert(ValeurNutritionnelle valeurNutritionnelle, Produit produit);
}