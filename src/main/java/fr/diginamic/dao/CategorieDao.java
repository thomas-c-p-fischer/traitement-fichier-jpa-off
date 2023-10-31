package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entities.Categorie;

/** Dao pour l'entité Categorie */
public interface CategorieDao {
	List<Categorie> extraire();
	void insert(Categorie categorie);
	boolean existe(String nom);
}
