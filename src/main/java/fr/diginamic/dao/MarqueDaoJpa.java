package fr.diginamic.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.diginamic.entities.Marque;

/** Classe avec les méthodes SQL concernant Marque */
public class MarqueDaoJpa implements MarqueDao {

	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public MarqueDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

    @Override
    public List<Marque> extraire() {
        List<Marque> marques = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            marques = em.createQuery("SELECT m FROM Marque m", Marque.class).getResultList();
            for (Marque marqueExtract : marques) {
                Marque marque = new Marque(marqueExtract.getNom());
                marques.add(marque);
            }
        } finally {
            em.close();
        }
        return marques;
    }

    @Override
    public void insert(Marque marque) {
        EntityManager em = emf.createEntityManager();
        try {
            Marque marqueInsert = new Marque();
            marqueInsert.setNom(marque.getNom());
            em.persist(marqueInsert);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean existe(String nom) {
        EntityManager em = emf.createEntityManager();
        try {
            Long count = em.createQuery("SELECT COUNT(m) FROM Marque m WHERE m.nom = :nom", Long.class)
                    .setParameter("nom", nom)
                    .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
}