package fr.diginamic.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.diginamic.entities.Produit;
import fr.diginamic.entities.Vitamine;

/** Classe avec les méthodes SQL concernant Vitamine */
public class VitamineDaoJpa implements VitamineDao {
	
	/** emf */
	private EntityManagerFactory emf;

	/**
	 * Constructeur Dao
	 */
	public VitamineDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

    @Override
    public void insert(Vitamine vitamine, Produit produit) {
    	EntityManager em = emf.createEntityManager();
    	try {
    		Vitamine vitamineInsert = new Vitamine();
    		vitamineInsert.setBetaCarotene100g(vitamine.getBetaCarotene100g());
    		vitamineInsert.setCalcium100g(vitamine.getCalcium100g());
    		vitamineInsert.setFer100g(vitamine.getFer100g());
    		vitamineInsert.setIron100g(vitamine.getIron100g());
    		vitamineInsert.setMagnesium100g(vitamine.getMagnesium100g());
    		vitamineInsert.setVitA100g(vitamine.getVitA100g());
    		vitamineInsert.setVitB1100g(vitamine.getVitB1100g());
    		vitamineInsert.setVitB12100g(vitamine.getVitB12100g());
    		vitamineInsert.setVitB2100g(vitamine.getVitB2100g());
    		vitamineInsert.setVitB6100g(vitamine.getVitB6100g());
    		vitamineInsert.setVitB9100g(vitamine.getVitB9100g());
    		vitamineInsert.setVitC100g(vitamine.getVitC100g());
    		vitamineInsert.setVitD100g(vitamine.getVitD100g());
    		vitamineInsert.setVitE100g(vitamine.getVitE100g());
    		vitamineInsert.setVitK100g(vitamine.getVitK100g());
    		vitamineInsert.setVitPP100g(vitamine.getVitPP100g());
    		vitamineInsert.setProduit(produit);
            em.persist(vitamineInsert);
		} finally {
			em.close();
		}
    }
}