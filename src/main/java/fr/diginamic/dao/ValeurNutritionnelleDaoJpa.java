package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entities.Produit;
import fr.diginamic.entities.ValeurNutritionnelle;

/** Classe avec les méthodes SQL concernant ValeurNutritionnelle */
public class ValeurNutritionnelleDaoJpa implements ValeurNutritionnelleDao {
	
	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public ValeurNutritionnelleDaoJpa() {
		emf = Persistence.createEntityManagerFactory("food-facts");
	}

	@Override
	public void insert(ValeurNutritionnelle valeurNutritionnelle, Produit produit) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			ValeurNutritionnelle insertValeurNutritionnelle = new ValeurNutritionnelle();
			insertValeurNutritionnelle.setEnergie100g(valeurNutritionnelle.getEnergie100g());
			insertValeurNutritionnelle.setGraisse100g(valeurNutritionnelle.getGraisse100g());
			insertValeurNutritionnelle.setSucre100g(valeurNutritionnelle.getSucre100g());
			insertValeurNutritionnelle.setFibre100g(valeurNutritionnelle.getFibre100g());
			insertValeurNutritionnelle.setProteine100g(valeurNutritionnelle.getProteine100g());
			insertValeurNutritionnelle.setSel100g(valeurNutritionnelle.getSel100g());
			insertValeurNutritionnelle.setProduit(produit);			
			em.persist(insertValeurNutritionnelle);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
	}
}