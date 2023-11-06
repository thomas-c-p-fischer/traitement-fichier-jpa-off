package fr.diginamic.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.diginamic.entities.Produit;
import fr.diginamic.entities.ValeurNutritionnelle;

/** Classe avec les méthodes SQL concernant ValeurNutritionnelle */
public class ValeurNutritionnelleDaoJpa implements ValeurNutritionnelleDao {
	
	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public ValeurNutritionnelleDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(ValeurNutritionnelle valeurNutritionnelle, Produit produit) {
		EntityManager em = emf.createEntityManager();
		try {
			ValeurNutritionnelle insertValeurNutritionnelle = new ValeurNutritionnelle();
			insertValeurNutritionnelle.setEnergie100g(valeurNutritionnelle.getEnergie100g());
			insertValeurNutritionnelle.setGraisse100g(valeurNutritionnelle.getGraisse100g());
			insertValeurNutritionnelle.setSucre100g(valeurNutritionnelle.getSucre100g());
			insertValeurNutritionnelle.setFibre100g(valeurNutritionnelle.getFibre100g());
			insertValeurNutritionnelle.setProteine100g(valeurNutritionnelle.getProteine100g());
			insertValeurNutritionnelle.setSel100g(valeurNutritionnelle.getSel100g());
			insertValeurNutritionnelle.setProduit(produit);			
			em.persist(insertValeurNutritionnelle);
		} finally {
			em.close();
		}
		
	}
}