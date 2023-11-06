package fr.diginamic.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.diginamic.entities.Ingredient;

/** Classe avec les méthodes SQL concernant Ingredient */
public class IngredientDaoJpa implements IngredientDao {
	
	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public IngredientDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Ingredient ingredient) {
		EntityManager em = emf.createEntityManager();
		try {
			Ingredient ingredientInsert = new Ingredient();
			ingredientInsert.setNom(ingredient.getNom());
			em.persist(ingredientInsert);
		} finally {
			em.close();
		}
	}

	@Override
	public boolean existe(String nom) {
		EntityManager em = emf.createEntityManager();
		try {
			Long count = em.createQuery("SELECT COUNT(i) FROM Ingredient i WHERE i.nom = :nom", Long.class)
					.setParameter("nom", nom).getSingleResult();
			return count > 0;
		} finally {
			em.close();
		}
	}
}