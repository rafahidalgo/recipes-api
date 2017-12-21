package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints.Required;

/**
 * Clase modelo que representa la tabla Ingredient donde se guardan los ingredientes de las recetas.
 * @author MIMO
 *
 */

@Entity
public class Ingredient extends Model {
	
	/**
	 * Permite hacer búsquedas de ingredientes
	 */
	public static final Finder<Long, Ingredient> find = new Finder<>(Ingredient.class);

	/**
	 * Id del ingrediente
	 */
	@Id
	Long ingredientId;

	/**
	 * Nombre del ingrediente
	 */
	@Required
	String ingredientName;

	/**
	 * Unidades del ingrediente.
	 */
	@Required
	String units;
	
	/**
	 * Recetas en las que se encuentra el ingrediente
	 */
	@JsonBackReference
	@ManyToMany(mappedBy="ingredients")
	public Set<Recipe> recipes;

	
	/**
	 * Constructor de la clase Ingredient
	 * @param ingredientName Nombre del ingrediente
	 * @param units Unidades del ingrediente
	 */
	public Ingredient(@Required String ingredientName, @Required String units) {
		
		super();
		this.ingredientName = ingredientName;
		this.units = units;
	}
	
	/**
	 * Método que comprueba si un ingrediente ya existe
	 * @param name Nombre del ingrediente
	 * @param units Unidades del ingrediente
	 * @return UN objeto con la instancia del ingrediente
	 */
	public static Ingredient findIngredientByNameAndUnit(String name, String units) {
		return find.query().where().isNotNull("ingredientName").eq("ingredientName", name)
				.and().isNotNull("units").eq("units", units).findOne();
	}

	/**
	 * Getter de ingredientId
	 * @return Devuelve el identificador del ingrediente
	 */
	public Long getIngredientId() {
		return ingredientId;
	}

	/**
	 * Setter de ingredientId
	 * @param ingredientId El identificador del ingrediente
	 */
	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	/**
	 * Getter de ingredientName
	 * @return Devuelve el nombre del ingrediente
	 */
	public String getIngredientName() {
		return ingredientName;
	}

	/**
	 * Setter de ingredientName
	 * @param ingredientName El nombre del ingrediente
	 */
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	
	/**
	 * Getter de units
	 * @return Devuelve las unidades del ingrediente
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * Setter de units
	 * @param units Las unidades del ingrediente
	 */
	public void setUnits(String units) {
		this.units = units;
	}
	
}
