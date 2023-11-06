package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Allergene;
import fr.diginamic.entities.Categorie;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.entities.Marque;
import fr.diginamic.entities.Produit;

/** Classe avec les méthodes SQL concernant Produit */
public class ProduitDaoJpa implements ProduitDao {
	
	
	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public ProduitDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Produit produit, String nomCategorie, String nomMarque, Set<String> nomsIngredients,
			Set<String> nomsAdditifs, Set<String> nomsAllergenes) {
		EntityManager em = emf.createEntityManager();
		try {
			Categorie categorie = em.createQuery("SELECT c FROM Categorie c WHERE c.nom = :nom", Categorie.class)
					.setParameter("nom", nomCategorie)
					.getSingleResult();
			Marque marque = em.createQuery("SELECT m FROM Marque m WHERE m.nom = :nom", Marque.class)
					.setParameter("nom", nomMarque)
					.getSingleResult();
			List<Ingredient> ingredients = new ArrayList<>();
			for (String nomIngredient : nomsIngredients) {
				Ingredient ingredient= em.createQuery("SELECT i FROM Ingredient i WHERE i.nom = :nom", Ingredient.class)
						.setParameter("nom", nomIngredient)
						.getSingleResult();
				ingredients.add(ingredient);
			}
			List<Additif> additifs = new ArrayList<>();
			for(String nomAdditif : nomsAdditifs) {
				Additif additif = em.createQuery("SELECT a FROM Additif a WHERE a.nom = :nom", Additif.class)
						.setParameter("nom", nomAdditif)
						.getSingleResult();
				additifs.add(additif);
			}
			List<Allergene> allergenes = new ArrayList<>();
			for(String nomAllergene : nomsAllergenes) {
				Allergene allergene = em.createQuery("SELECT a FROM Allergene a WHERE a.nom = :nom", Allergene.class)
						.setParameter("nom", nomAllergene)
						.getSingleResult();
				allergenes.add(allergene);
			}
			Produit produitInsert = new Produit();
			produitInsert.setNom(produit.getNom());
			produitInsert.setNutritionGrade(produit.getNutritionGrade());
			produitInsert.setPresenceHuileDePalme(produit.isPresenceHuileDePalme());
			produitInsert.setCategorie(categorie);
			produitInsert.setMarque(marque);
			produitInsert.setIngredients(ingredients);
			produitInsert.setAdditifs(additifs);
			produitInsert.setAllergenes(allergenes);
			em.persist(produitInsert);
		} finally {
			em.close();
		}
	}

	@Override
	public boolean existe(String nom) {
		EntityManager em = emf.createEntityManager();
		try {
			Long count = em.createQuery("SELECT COUNT(p) FROM Produit p WHERE p.nom = :nom", Long.class)
					.setParameter("nom", nom).getSingleResult();
			return count > 0;
		} finally {
			em.close();
		}
	}
}