package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entities.Marque;

/** Dao pour l'entité Marque */
public interface MarqueDao {
	List<Marque> extraire();
	void insert(Marque marque);
	boolean existe(String nom);
}