/** Package contenant les Entités */
package fr.diginamic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Entité Categorie */
@Entity
@Table(name = "CATEGORIE")
public class Categorie {
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** nom */
	@Column(name = "NOM", nullable = false, length = 250, unique = true)
	private String nom;
	
	/** produits */
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits = new ArrayList<>();

	/** Constructeur
	 * 
	 */
	public Categorie() {
	}

	/** Constructeur pour la requête SELECT
	 * @param nom
	 */
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Categorie: " + nom + ", id: " + id + ".";
	}

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/** Setter
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}