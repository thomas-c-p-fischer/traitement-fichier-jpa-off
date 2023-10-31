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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** Entité Produit */
@Entity
@Table(name="PRODUIT")
public class Produit {
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** categorie */
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIE")
	private Categorie categorie;
	
	/** marque */
	@ManyToOne
	@JoinColumn(name = "ID_MARQUE")
	private Marque marque;
	
	/** nom */
	@Column(name = "NAME", nullable = false, length = 250, unique = true)
	private String nom;
	
	/** nutritionGrade */
	@Column(name = "NUTRITION_GRADE", nullable = false, length = 10)
	private String nutritionGrade;
	
	/** presenceHuileDePalme */
	@Column(name = "PRESENCE_HUILE_DE_PALME", nullable = false)
	private boolean presenceHuileDePalme;
	
	/** ingredients */
	@ManyToMany
	@JoinTable(name = "PODUIT_INGREDIENT",
				joinColumns = @JoinColumn(name="ID_PRODUIT", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name="ID_INGREDIENT", referencedColumnName = "ID"))
	private List<Ingredient> ingredients = new ArrayList<>();
	
	/** additifs */
	@ManyToMany
	@JoinTable(name = "PODUIT_ADDITIF",
				joinColumns = @JoinColumn(name="ID_PRODUIT", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name="ID_ADDITIF", referencedColumnName = "ID"))
	private List<Additif> additifs = new ArrayList<>();
	
	/** valeurNutritionnelles */
	@OneToOne
	@JoinColumn(name = "ID_VALEUR_NUTRITIONNELLE")
	private ValeurNutritionnelle valeurNutritionnelle;
	
	/** vitamines */
	@OneToOne
	@JoinColumn(name = "ID_VITAMINE")
	private Vitamine vitamine;
	
	/** allergenes */
	@ManyToMany
	@JoinTable(name = "PODUIT_ALLERGENE",
				joinColumns = @JoinColumn(name="ID_PRODUIT", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name="ID_ALLERGENE", referencedColumnName = "ID"))
	private List<Allergene> allergenes = new ArrayList<>();

	/** Constructeur
	 * 
	 */
	public Produit() {
	}
	
	/** Constructeur pour la requête SELECT
	 * @param nom
	 * @param nutritionGrade
	 * @param presenceHuileDePalme
	 */
	public Produit(String nom, String nutritionGrade, boolean presenceHuileDePalme) {
		super();
		this.nom = nom;
		this.nutritionGrade = nutritionGrade;
		this.presenceHuileDePalme = presenceHuileDePalme;
	}

	@Override
	public String toString() {
		return "Produit: " + nom + ", id: " + id + ", note nutritionnelle: " + nutritionGrade + ", presence d'huile de palme: "
				+ presenceHuileDePalme + ".";
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
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/** Getter
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/** Setter
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
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
	 * @return the nutritionGrade
	 */
	public String getNutritionGrade() {
		return nutritionGrade;
	}

	/** Setter
	 * @param nutritionGrade the nutritionGrade to set
	 */
	public void setNutritionGrade(String nutritionGrade) {
		this.nutritionGrade = nutritionGrade;
	}

	/** Getter
	 * @return the presenceHuileDePalme
	 */
	public boolean isPresenceHuileDePalme() {
		return presenceHuileDePalme;
	}

	/** Setter
	 * @param presenceHuileDePalme the presenceHuileDePalme to set
	 */
	public void setPresenceHuileDePalme(boolean presenceHuileDePalme) {
		this.presenceHuileDePalme = presenceHuileDePalme;
	}

	/** Getter
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/** Setter
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/** Getter
	 * @return the additifs
	 */
	public List<Additif> getAdditifs() {
		return additifs;
	}

	/** Setter
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}

	/** Getter
	 * @return the valeurNutritionnelles
	 */
	public ValeurNutritionnelle getValeurNutritionnelle() {
		return valeurNutritionnelle;
	}

	/** Setter
	 * @param valeurNutritionnelles the valeurNutritionnelles to set
	 */
	public void setValeurNutritionnelle(ValeurNutritionnelle valeurNutritionnelle) {
		this.valeurNutritionnelle = valeurNutritionnelle;
	}

	/** Getter
	 * @return the vitamines
	 */
	public Vitamine getVitamine() {
		return vitamine;
	}

	/** Setter
	 * @param vitamines the vitamines to set
	 */
	public void setVitamine(Vitamine vitamine) {
		this.vitamine = vitamine;
	}

	/** Getter
	 * @return the allergenes
	 */
	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	/** Setter
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}
}