package fr.diginamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.mariadb.jdbc.Driver;

import fr.diginamic.dao.AdditifDaoJpa;
import fr.diginamic.dao.AllergeneDaoJpa;
import fr.diginamic.dao.CategorieDaoJpa;
import fr.diginamic.dao.IngredientDaoJpa;
import fr.diginamic.dao.MarqueDaoJpa;
import fr.diginamic.dao.ProduitDaoJpa;
import fr.diginamic.dao.ValeurNutritionnelleDaoJpa;
import fr.diginamic.dao.VitamineDaoJpa;
import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Allergene;
import fr.diginamic.entities.Categorie;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.entities.Marque;
import fr.diginamic.entities.Produit;
import fr.diginamic.entities.ValeurNutritionnelle;
import fr.diginamic.entities.Vitamine;

/** Classe permettant l'insertion en bdd */
public class IntegrationOpenFoodFacts {

	/**
	 * Méthode main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String nomFichier = "open-food-facts.csv";
		// J'instancie mon lecteur de fichier CSV
		LecteurCSV lecteurCSV = new LecteurCSV();
		// Ici j'appelle la méthode qui me permet de lire un fichier et de le mettre
		// dans une List
		List<String> donneesFichier = lecteurCSV.lectureFichier(nomFichier);
		// Ici j'appelle la méthode qui me permet de classé ma List avant de pouvoir
		// l'insérer en BDD
		List<String[]> donneesAInserer = lecteurCSV.lectureListe(donneesFichier);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("food-facts");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
				
		MarqueDaoJpa marqueDao = new MarqueDaoJpa(emf);
		CategorieDaoJpa categorieDao = new CategorieDaoJpa(emf);
		AdditifDaoJpa additifDao = new AdditifDaoJpa(emf);
		AllergeneDaoJpa allergeneDao = new AllergeneDaoJpa(emf);
		IngredientDaoJpa ingredientDao = new IngredientDaoJpa(emf);
		ProduitDaoJpa produitDao = new ProduitDaoJpa(emf);
		ValeurNutritionnelleDaoJpa valeurNutritionnelleDao = new ValeurNutritionnelleDaoJpa(emf);
		VitamineDaoJpa vitamineDao = new VitamineDaoJpa(emf);
		transaction.begin();
		Map<String, Marque> marquesCache = new HashMap<>();
		Map<String, Categorie> categoriesCache = new HashMap<>();
		Map<String, Additif> additifsCache = new HashMap<>();
        Map<String, Allergene> allergenesCache = new HashMap<>();
        Map<String, Ingredient> ingredientsCache = new HashMap<>();
        
		for (String[] ligne : donneesAInserer) {
			String nomMarque = ligne[1];
			Marque marque = marquesCache.computeIfAbsent(nomMarque, k -> new Marque(nomMarque));
			if (!(marqueDao.existe(nomMarque) == true)) {
				marqueDao.insert(marque);
			}
			String nomCategorie = ligne[0];
			Categorie categorie = categoriesCache.computeIfAbsent(nomCategorie, k -> new Categorie(nomCategorie));
			if (!categorieDao.existe(nomCategorie)) {
                categorieDao.insert(categorie);
            }
			Set<String> additifs = new LinkedHashSet<>();
            String[] additifsTokens = ligne[29].split(",");
            for (String nomAdditif : additifsTokens) {
                additifs.add(nomAdditif.trim());
            }
            additifs.forEach(nomAdditif -> {
                Additif additif = additifsCache.computeIfAbsent(nomAdditif, k -> new Additif(nomAdditif));
                if (!additifDao.existe(nomAdditif)) {
                    additifDao.insert(additif);
                }
            });
            Set<String> allergenes = new LinkedHashSet<>();
            String[] allergenesTokens = ligne[28].split(",");
            for (String nomAllergene : allergenesTokens) {
                allergenes.add(nomAllergene.trim());
            }
            allergenes.forEach(nomAllergene -> {
                if (nomAllergene != null) {
                    Allergene allergene = allergenesCache.computeIfAbsent(nomAllergene, k -> new Allergene(nomAllergene));
                    if (!allergeneDao.existe(nomAllergene)) {
                        allergeneDao.insert(allergene);
                    }
                }
            });
            Set<String> ingredients = new LinkedHashSet<>();
            String[] ingredientTokens = ligne[4].split(",");
            for (String nomIngredient : ingredientTokens) {
                ingredients.add(nomIngredient.trim());
            }
            ingredients.forEach(nomIngredient -> {
                Ingredient ingredient = ingredientsCache.computeIfAbsent(nomIngredient, k -> new Ingredient(nomIngredient));
                if (!ingredientDao.existe(nomIngredient)) {
                    ingredientDao.insert(ingredient);
                }
            });
			String nomProduit = ligne[2];
			String noteProduit = ligne[3];
			boolean huileDepalme = Boolean.parseBoolean(ligne[27]);
			Produit produit = new Produit(nomProduit, noteProduit, huileDepalme);
			if(!(produitDao.existe(nomProduit)) == true) {
				produitDao.insert(produit, nomCategorie, nomMarque, ingredients, additifs, allergenes);
			}
//			float energie = Float.parseFloat(ligne[5]);
//			float graisse = Float.parseFloat(ligne[6]);
//			float sucre = Float.parseFloat(ligne[7]);
//			float fibre = Float.parseFloat(ligne[8]);
//			float proteine = Float.parseFloat(ligne[9]);
//			float sel = Float.parseFloat(ligne[10]);
//			ValeurNutritionnelle valeurNutritionnelle = new ValeurNutritionnelle(energie, graisse, sucre, fibre, proteine, sel);
//			valeurNutritionnelleDao.insert(valeurNutritionnelle, produit);
//			float vitA = Float.parseFloat(ligne[11]);
//			float vitD = Float.parseFloat(ligne[12]);
//			float vitE = Float.parseFloat(ligne[13]);
//			float vitK = Float.parseFloat(ligne[14]);
//			float vitC = Float.parseFloat(ligne[15]);
//			float vitB1 = Float.parseFloat(ligne[16]);
//			float vitB2 = Float.parseFloat(ligne[17]);
//			float vitPP = Float.parseFloat(ligne[18]);
//			float vitB6 = Float.parseFloat(ligne[19]);
//			float vitB9 = Float.parseFloat(ligne[20]);
//			float vitB12 = Float.parseFloat(ligne[21]);
//			float calc = Float.parseFloat(ligne[22]);
//			float magn = Float.parseFloat(ligne[23]);
//			float iron = Float.parseFloat(ligne[24]);
//			float fer = Float.parseFloat(ligne[25]);
//			float betaCar = Float.parseFloat(ligne[26]);
//			Vitamine vitamine = new Vitamine(vitA, vitD, vitE, vitK, vitC, vitB1, vitB2, vitPP, vitB6, vitB9, vitB12, calc, magn, iron, fer, betaCar);
//			vitamineDao.insert(vitamine, produit);
		}
		transaction.commit();
	}	
}