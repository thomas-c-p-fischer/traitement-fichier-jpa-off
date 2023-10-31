/** Package contenant les Entités */
package fr.diginamic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** Entité ValeurNutritionnelle */
@Entity
@Table(name = "VALEUR_NUTRITIONNELLE")
public class ValeurNutritionnelle {
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** energie100g */
	@Column(name = "ENERGIE_100G", nullable = true)
	private float energie100g;
	
	/** graisse100g */
	@Column(name = "GRAISSE_100G", nullable = true)
	private float graisse100g;
	
	/** sucre100g */
	@Column(name = "SUCRE_100G", nullable = true)
	private float sucre100g;
	
	/** fibre100g */
	@Column(name = "FIBRE_100G", nullable = true)
	private float fibre100g;
	
	/** proteine100g */
	@Column(name = "PROTEINE_100G", nullable = true)
	private float proteine100g;
	
	/** sel100g */
	@Column(name = "SEL_100G", nullable = true)
	private float sel100g;
	
	/** produit */
	@OneToOne
	@JoinColumn(name = "ID_PRODUIT")
	private Produit produit;

	/** Constructeur
	 * 
	 */
	public ValeurNutritionnelle() {
	}

	/** Constructeur
	 * @param energie
	 * @param graisse
	 * @param sucre
	 * @param fibre
	 * @param proteine
	 * @param sel
	 */
	public ValeurNutritionnelle(float energie, float graisse, float sucre, float fibre, float proteine, float sel) {
		super();
	}

	@Override
	public String toString() {
		return "Id de la valeur nutritionnelle:" + id + ", energie 100g: " + energie100g + "g, graisse 100g: " + graisse100g
				+ "g, sucre 100g=" + sucre100g + "g, fibre 100g=" + fibre100g + "g, proteine 100g=" + proteine100g
				+ "g, sel 100g=" + sel100g + ".";
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
	 * @return the energie100g
	 */
	public float getEnergie100g() {
		return energie100g;
	}

	/** Setter
	 * @param energie100g the energie100g to set
	 */
	public void setEnergie100g(float energie100g) {
		this.energie100g = energie100g;
	}

	/** Getter
	 * @return the graisse100g
	 */
	public float getGraisse100g() {
		return graisse100g;
	}

	/** Setter
	 * @param graisse100g the graisse100g to set
	 */
	public void setGraisse100g(float graisse100g) {
		this.graisse100g = graisse100g;
	}

	/** Getter
	 * @return the sucre100g
	 */
	public float getSucre100g() {
		return sucre100g;
	}

	/** Setter
	 * @param sucre100g the sucre100g to set
	 */
	public void setSucre100g(float sucre100g) {
		this.sucre100g = sucre100g;
	}

	/** Getter
	 * @return the fibre100g
	 */
	public float getFibre100g() {
		return fibre100g;
	}

	/** Setter
	 * @param fibre100g the fibre100g to set
	 */
	public void setFibre100g(float fibre100g) {
		this.fibre100g = fibre100g;
	}

	/** Getter
	 * @return the proteine100g
	 */
	public float getProteine100g() {
		return proteine100g;
	}

	/** Setter
	 * @param proteine100g the proteine100g to set
	 */
	public void setProteine100g(float proteine100g) {
		this.proteine100g = proteine100g;
	}

	/** Getter
	 * @return the sel100g
	 */
	public float getSel100g() {
		return sel100g;
	}

	/** Setter
	 * @param sel100g the sel100g to set
	 */
	public void setSel100g(float sel100g) {
		this.sel100g = sel100g;
	}

	/** Getter
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/** Setter
	 * @param produit the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
}