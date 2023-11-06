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
import fr.diginamic.entities.Allergene;

/** Classe avec les méthodes SQL concernant Allergene */
public class AllergeneDaoJpa implements AllergeneDao {

	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public AllergeneDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Allergene allergene) {
		EntityManager em = emf.createEntityManager();
		try {
			Allergene allergeneInsert = new Allergene();
			allergeneInsert.setNom(allergene.getNom());
			em.persist(allergeneInsert);
		} finally {
			em.close();
		}
	}

	@Override
	public boolean existe(String nom) {
		EntityManager em = emf.createEntityManager();
		try {
			Long count = em.createQuery("SELECT COUNT(a) FROM Allergene a WHERE a.nom = :nom", Long.class)
					.setParameter("nom", nom).getSingleResult();
			return count > 0;
		} finally {
			em.close();
		}
	}
}