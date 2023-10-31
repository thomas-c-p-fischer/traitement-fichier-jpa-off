package fr.diginamic.dao;

import fr.diginamic.entities.Allergene;

/** Dao pour l'entité Allergene **/
public interface AllergeneDao {
	void insert(Allergene allergene);
	boolean existe(String nom);
}