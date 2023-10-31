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

/** Entité Vitamine */
@Entity
@Table(name="VITAMINE")
public class Vitamine {
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** vitA100g */
	@Column(name = "VIT_A_100G", nullable = true)
	private float vitA100g;
	
	/** vitD100g */
	@Column(name = "VIT_D_100G", nullable = true)
	private float vitD100g;
	
	/** vitE100g */
	@Column(name = "VIT_E_100G", nullable = true)
	private float vitE100g;
	
	/** vitK100g */
	@Column(name = "VIT_K_100G", nullable = true)
	private float vitK100g;
	
	/** vitC100g */
	@Column(name = "VIT_C_100G", nullable = true)
	private float vitC100g;
	
	/** vitB1100g */
	@Column(name = "VIT_B1_100G", nullable = true)
	private float vitB1100g;
	
	/** vitB2100g */
	@Column(name = "VIT_B2_100G", nullable = true)
	private float vitB2100g;
	
	/** vitPP100g */
	@Column(name = "VIT_PP_100G", nullable = true)
	private float vitPP100g;
	
	/** vitB6100g */
	@Column(name = "VIT_B6_100G", nullable = true)
	private float vitB6100g;
	
	/** vitB9100g */
	@Column(name = "VIT_B9_100G", nullable = true)
	private float vitB9100g;
	
	/** vitB12100g */
	@Column(name = "VIT_B12_100G", nullable = true)
	private float vitB12100g;
	
	/** calcium100g */
	@Column(name = "CALCIUM_100G", nullable = true)
	private float calcium100g;
	
	/** magnesium100g */
	@Column(name = "MAGNESIUM_100G", nullable = true)
	private float magnesium100g;
	
	/** iron100g */
	@Column(name = "IRON_100G", nullable = true)
	private float iron100g;
	
	/** fer100g */
	@Column(name = "FER_100G", nullable = true)
	private float fer100g;
	
	/** betaCarotene100g */
	@Column(name = "BETA_CAROTENE_100G", nullable = true)
	private float betaCarotene100g;
	
	/** produit */
	@OneToOne
	@JoinColumn(name = "ID_PRODUIT")
	private Produit produit;

	/** Constructeur
	 * 
	 */
	public Vitamine() {
	}
	
	/** Constructeur
	 * @param vitA100g
	 * @param vitD100g
	 * @param vitE100g
	 * @param vitK100g
	 * @param vitC100g
	 * @param vitB1100g
	 * @param vitB2100g
	 * @param vitPP100g
	 * @param vitB6100g
	 * @param vitB9100g
	 * @param vitB12100g
	 * @param calcium100g
	 * @param magnesium100g
	 * @param iron100g
	 * @param fer100g
	 * @param betaCarotene100g
	 */
	public Vitamine(float vitA100g, float vitD100g, float vitE100g, float vitK100g, float vitC100g, float vitB1100g,
			float vitB2100g, float vitPP100g, float vitB6100g, float vitB9100g, float vitB12100g, float calcium100g,
			float magnesium100g, float iron100g, float fer100g, float betaCarotene100g) {
		super();
		this.vitA100g = vitA100g;
		this.vitD100g = vitD100g;
		this.vitE100g = vitE100g;
		this.vitK100g = vitK100g;
		this.vitC100g = vitC100g;
		this.vitB1100g = vitB1100g;
		this.vitB2100g = vitB2100g;
		this.vitPP100g = vitPP100g;
		this.vitB6100g = vitB6100g;
		this.vitB9100g = vitB9100g;
		this.vitB12100g = vitB12100g;
		this.calcium100g = calcium100g;
		this.magnesium100g = magnesium100g;
		this.iron100g = iron100g;
		this.fer100g = fer100g;
		this.betaCarotene100g = betaCarotene100g;
	}

	@Override
	public String toString() {
		return "Vitamine [id=" + id + ", vitA100g=" + vitA100g + ", vitD100g=" + vitD100g + ", vitE100g=" + vitE100g
				+ ", vitK100g=" + vitK100g + ", vitC100g=" + vitC100g + ", vitB1100g=" + vitB1100g + ", vitB2100g="
				+ vitB2100g + ", vitPP100g=" + vitPP100g + ", vitB6100g=" + vitB6100g + ", vitB9100g=" + vitB9100g
				+ ", vitB12100g=" + vitB12100g + ", calcium100g=" + calcium100g + ", magnesium100g=" + magnesium100g
				+ ", iron100g=" + iron100g + ", fer100g=" + fer100g + ", betaCarotene100g=" + betaCarotene100g + "]";
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
	 * @return the vitA100g
	 */
	public float getVitA100g() {
		return vitA100g;
	}

	/** Setter
	 * @param vitA100g the vitA100g to set
	 */
	public void setVitA100g(float vitA100g) {
		this.vitA100g = vitA100g;
	}

	/** Getter
	 * @return the vitD100g
	 */
	public float getVitD100g() {
		return vitD100g;
	}

	/** Setter
	 * @param vitD100g the vitD100g to set
	 */
	public void setVitD100g(float vitD100g) {
		this.vitD100g = vitD100g;
	}

	/** Getter
	 * @return the vitE100g
	 */
	public float getVitE100g() {
		return vitE100g;
	}

	/** Setter
	 * @param vitE100g the vitE100g to set
	 */
	public void setVitE100g(float vitE100g) {
		this.vitE100g = vitE100g;
	}

	/** Getter
	 * @return the vitK100g
	 */
	public float getVitK100g() {
		return vitK100g;
	}

	/** Setter
	 * @param vitK100g the vitK100g to set
	 */
	public void setVitK100g(float vitK100g) {
		this.vitK100g = vitK100g;
	}

	/** Getter
	 * @return the vitC100g
	 */
	public float getVitC100g() {
		return vitC100g;
	}

	/** Setter
	 * @param vitC100g the vitC100g to set
	 */
	public void setVitC100g(float vitC100g) {
		this.vitC100g = vitC100g;
	}

	/** Getter
	 * @return the vitB1100g
	 */
	public float getVitB1100g() {
		return vitB1100g;
	}

	/** Setter
	 * @param vitB1100g the vitB1100g to set
	 */
	public void setVitB1100g(float vitB1100g) {
		this.vitB1100g = vitB1100g;
	}

	/** Getter
	 * @return the vitB2100g
	 */
	public float getVitB2100g() {
		return vitB2100g;
	}

	/** Setter
	 * @param vitB2100g the vitB2100g to set
	 */
	public void setVitB2100g(float vitB2100g) {
		this.vitB2100g = vitB2100g;
	}

	/** Getter
	 * @return the vitPP100g
	 */
	public float getVitPP100g() {
		return vitPP100g;
	}

	/** Setter
	 * @param vitPP100g the vitPP100g to set
	 */
	public void setVitPP100g(float vitPP100g) {
		this.vitPP100g = vitPP100g;
	}

	/** Getter
	 * @return the vitB6100g
	 */
	public float getVitB6100g() {
		return vitB6100g;
	}

	/** Setter
	 * @param vitB6100g the vitB6100g to set
	 */
	public void setVitB6100g(float vitB6100g) {
		this.vitB6100g = vitB6100g;
	}

	/** Getter
	 * @return the vitB9100g
	 */
	public float getVitB9100g() {
		return vitB9100g;
	}

	/** Setter
	 * @param vitB9100g the vitB9100g to set
	 */
	public void setVitB9100g(float vitB9100g) {
		this.vitB9100g = vitB9100g;
	}

	/** Getter
	 * @return the vitB12100g
	 */
	public float getVitB12100g() {
		return vitB12100g;
	}

	/** Setter
	 * @param vitB12100g the vitB12100g to set
	 */
	public void setVitB12100g(float vitB12100g) {
		this.vitB12100g = vitB12100g;
	}

	/** Getter
	 * @return the calcium100g
	 */
	public float getCalcium100g() {
		return calcium100g;
	}

	/** Setter
	 * @param calcium100g the calcium100g to set
	 */
	public void setCalcium100g(float calcium100g) {
		this.calcium100g = calcium100g;
	}

	/** Getter
	 * @return the magnesium100g
	 */
	public float getMagnesium100g() {
		return magnesium100g;
	}

	/** Setter
	 * @param magnesium100g the magnesium100g to set
	 */
	public void setMagnesium100g(float magnesium100g) {
		this.magnesium100g = magnesium100g;
	}

	/** Getter
	 * @return the iron100g
	 */
	public float getIron100g() {
		return iron100g;
	}

	/** Setter
	 * @param iron100g the iron100g to set
	 */
	public void setIron100g(float iron100g) {
		this.iron100g = iron100g;
	}

	/** Getter
	 * @return the fer100g
	 */
	public float getFer100g() {
		return fer100g;
	}

	/** Setter
	 * @param fer100g the fer100g to set
	 */
	public void setFer100g(float fer100g) {
		this.fer100g = fer100g;
	}

	/** Getter
	 * @return the betaCarotene100g
	 */
	public float getBetaCarotene100g() {
		return betaCarotene100g;
	}

	/** Setter
	 * @param betaCarotene100g the betaCarotene100g to set
	 */
	public void setBetaCarotene100g(float betaCarotene100g) {
		this.betaCarotene100g = betaCarotene100g;
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