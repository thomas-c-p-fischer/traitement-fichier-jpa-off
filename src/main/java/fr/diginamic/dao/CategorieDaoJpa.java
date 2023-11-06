package fr.diginamic.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.diginamic.entities.Categorie;

/** Classe avec les méthodes SQL concernant Categorie */
public class CategorieDaoJpa implements CategorieDao {

	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public CategorieDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Categorie> extraire() {
		List<Categorie> categories = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		try {
			categories = em.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
			for (Categorie categorieExtract : categories) {
				Categorie categorie = new Categorie(categorieExtract.getNom());
				categories.add(categorie);
			}
		} finally {
			em.close();
		}
		return categories;
	}

	@Override
	public void insert(Categorie categorie) {
		EntityManager em = emf.createEntityManager();
		try {
			Categorie categorieInsert = new Categorie();
			categorieInsert.setNom(categorie.getNom());
			em.persist(categorieInsert);
		} finally {
			em.close();
		}
	}

	@Override
	public boolean existe(String nom) {
		EntityManager em = emf.createEntityManager();
		try {
			Long count = em.createQuery("SELECT COUNT(c) FROM Categorie c WHERE c.nom = :nom", Long.class)
					.setParameter("nom", nom).getSingleResult();
			return count > 0;
		} finally {
			em.close();
		}
	}
}