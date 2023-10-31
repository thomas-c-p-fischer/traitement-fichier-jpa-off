package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Categorie;

/** Classe avec les méthodes SQL concernant Additif */
public class AdditifDaoJpa implements AdditifDao {

	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public AdditifDaoJpa() {
		emf = Persistence.createEntityManagerFactory("food-facts");
	}

	@Override
	public void insert(Additif additif) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Additif additifInsert = new Additif();
			additifInsert.setNom(additif.getNom());
			em.persist(additifInsert);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public boolean existe(String nom) {
		EntityManager em = emf.createEntityManager();
		try {
			Long count = em.createQuery("SELECT COUNT(a) FROM Additif a WHERE a.nom = :nom", Long.class)
					.setParameter("nom", nom).getSingleResult();
			return count > 0;
		} finally {
			em.close();
		}
	}
}