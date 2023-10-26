/** Package contenant les Entités */
package fr.diginamic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/** Entité Ingredient */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient {
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** nom */
	@Column(name = "NOM", length = 250, nullable = false, unique = true)
	private String nom;
	
	/** pourcentage */
	@Column(name = "POURCENTAGE", nullable = false)
	private float pourcentage;
	
	/** produits */
	@ManyToMany
	@JoinTable(name = "PODUIT_INGREDIENT",
			joinColumns = @JoinColumn(name="ID_INGREDIENT", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name="ID_PRODUIT", referencedColumnName = "ID"))
	private List<Produit> produits = new ArrayList<>();

	/** Constructeur
	 * 
	 */
	public Ingredient() {
	}

	@Override
	public String toString() {
		return "Ingredient: " + nom + ", id: " + id + ", pourcentage: " + pourcentage + "%.";
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
	 * @return the pourcentage
	 */
	public float getPourcentage() {
		return pourcentage;
	}

	/** Setter
	 * @param pourcentage the pourcentage to set
	 */
	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
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