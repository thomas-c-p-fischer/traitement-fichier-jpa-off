package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Marque;

/** Dao pour l'entité Additif */
public interface AdditifDao {
	void insert(Additif additif);

	boolean existe(String nom);
}