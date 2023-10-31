package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entities.Produit;
import fr.diginamic.entities.Vitamine;

/** Dao pour l'entité Vitamine */
public interface VitamineDao {
	void insert(Vitamine vitamine, Produit produit);
}