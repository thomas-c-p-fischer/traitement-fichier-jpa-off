package fr.diginamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Classe permettant la lecture du fichier CSV */
public class LecteurCSV {
	
	/** Méthode de lecture du fichier
	 * @param nomFichier
	 * @return
	 */
	public List<String> lectureFichier(String nomFichier) {
		
		List<String> donnees = new ArrayList<>();
		ClassLoader cl = getClass().getClassLoader();
		InputStream is = cl.getResourceAsStream(nomFichier);
		
		if(is == null) {
			throw new RuntimeException("Le fichier .csv n'a pas été trouvé: " + nomFichier);
		}
		
		try(BufferedReader lecteur = new BufferedReader(new InputStreamReader(is))) {
			String ligne;
			lecteur.readLine();
			while((ligne = lecteur.readLine()) != null) {
				donnees.add(ligne);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Une erreur est survenue lors de la lecture du ficher .csv.");
		}
		return donnees;
	}
	
	public List<String[]> lectureListe(List<String> donnees) {
		List<String[]> donneesClassees = new ArrayList<>();
		for (String ligne : donnees) {
	        String[] elements = ligne.split("\\|", -1);
	        donneesClassees.add(elements);
	    }
		return donneesClassees;
	}
	
	/** Méthode de lecture du fichier pour les catégories
	 * @param String nomFichier
	 * @return Set<String> donnee
	 */
	public Set<String> lectureFichierCategorie(String nomFichier) {
		
		Set<String> donnee = new LinkedHashSet<>();
		ClassLoader cl = getClass().getClassLoader();
		InputStream is = cl.getResourceAsStream(nomFichier);
		
		if(is == null) {
			throw new RuntimeException("Le fichier .csv n'a pas été trouvé: " + nomFichier);
		}
		
		try(BufferedReader lecteur = new BufferedReader(new InputStreamReader(is))) {
			String ligne;
			lecteur.readLine();
			while((ligne = lecteur.readLine()) != null) {
				String[] parties = ligne.split("\\|");
				if(parties.length > 0) {
					donnee.add(parties[0]);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Une erreur est survenue lors de la lecture du ficher .csv.");
		}
		return donnee;
	}
	
	/** Méthode de lecture du fichier pour les produits
	 * @param String nomFichier
	 * @return Set<String> donnee
	 */
	public Set<String> lectureFichierProduit(String nomFichier) {
			
		Set<String> donnee = new LinkedHashSet<>();
		ClassLoader cl = getClass().getClassLoader();
		InputStream is = cl.getResourceAsStream(nomFichier);
		
		if(is == null) {
			throw new RuntimeException("Le fichier .csv n'a pas été trouvé: " + nomFichier);
		}
		
		try(BufferedReader lecteur = new BufferedReader(new InputStreamReader(is))) {
			String ligne;
			lecteur.readLine();
			while((ligne = lecteur.readLine()) != null) {
				String[] parties = ligne.split("\\|");
				if(parties.length > 2) {
					donnee.add(parties[2]);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Une erreur est survenue lors de la lecture du ficher .csv.");
		}
		return donnee;
	}
	
	/** Méthode de lecture du fichier pour les marques
	 * @param String nomFichier
	 * @return Set<String> donnee
	 */
	public Set<String> lectureFichierMarque(String nomFichier) {
			
		Set<String> donnee = new LinkedHashSet<>();
		ClassLoader cl = getClass().getClassLoader();
		InputStream is = cl.getResourceAsStream(nomFichier);
		
		if(is == null) {
			throw new RuntimeException("Le fichier .csv n'a pas été trouvé: " + nomFichier);
		}
		
		try(BufferedReader lecteur = new BufferedReader(new InputStreamReader(is))) {
			String ligne;
			lecteur.readLine();
			while((ligne = lecteur.readLine()) != null) {
				String[] parties = ligne.split("\\|");
				if(parties.length > 1) {
					donnee.add(parties[1]);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Une erreur est survenue lors de la lecture du ficher .csv.");
		}
		return donnee;
	}
	
	/** Méthode de lecture du fichier pour les additifs
	 * @param String nomFichier
	 * @return List<List<String>> donnee
	 */
	public List<List<String>> lectureFichierAdditif(String nomFichier) {
		List<List<String>> donnee = new ArrayList<>();
		ClassLoader cl = getClass().getClassLoader();
		InputStream is = cl.getResourceAsStream(nomFichier);
		
		if(is == null) {
			throw new RuntimeException("Le fichier .csv n'a pas été trouvé: " + nomFichier);
		}
		
		try(BufferedReader lecteur = new BufferedReader(new InputStreamReader(is))) {
			String ligne;
			lecteur.readLine();
			while((ligne = lecteur.readLine()) != null) {
				String[] parties = ligne.split("\\|");
				if(parties.length > 29) {
					String[] additifs = parties[29].split(",");
					List<String> additifListe = new ArrayList<>();
					for(String additif : additifs) {
						additifListe.add(additif.trim());
					}
					donnee.add(additifListe);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Une erreur est survenue lors de la lecture du ficher .csv.");
		}
		
		return donnee;
    }
}