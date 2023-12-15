/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Nov 12, 2023
*/
package MealFitnessPlanPkg.beans;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * 
 */
@Entity
public class Meal {
	@Id
	@GeneratedValue
	private int id;
	String mealName;
	double calories;
	
	// default no-args constructor
	public Meal() {
	}
	
	// constructor
	public Meal(String mealName, double calories) {
	}
		
	// getters and setters

	/**
	 * @return the mealName
	 */
	public String getMealName() {
		return mealName;
	}

	/**
	 * @param mealName the mealName to set
	 */
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	/**
	 * @return the calories
	 */
	public double getCalories() {
		return calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Meal [mealName=" + mealName + ", calories=" + calories + "]";
	}
}
