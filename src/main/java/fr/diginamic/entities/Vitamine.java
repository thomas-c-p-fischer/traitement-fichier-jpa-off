/** Package contenant les Entités */
package fr.diginamic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "VIT_B9100G", nullable = true)
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

}
