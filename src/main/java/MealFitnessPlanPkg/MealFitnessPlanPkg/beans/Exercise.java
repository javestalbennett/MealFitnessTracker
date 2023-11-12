/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Nov 12, 2023
*/
package MealFitnessPlanPkg.MealFitnessPlanPkg.beans;

import jakarta.persistence.Embeddable;

/**
 * 
 */
@Embeddable
public class Exercise {
	private String exerciseName;
	private String amount; // number of reps, sets, time, etc. of some exercise

	// default no-args constructor
	public Exercise() {
		
	}
	
	// constructor
	public Exercise(String exerciseName, String amount)
	{
	}
	
	// getters and setters

	/**
	 * @return the exerciseName
	 */
	public String getExerciseName() {
		return exerciseName;
	}

	/**
	 * @param exerciseName the exerciseName to set
	 */
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Exercise [exerciseName=" + exerciseName + ", amount=" + amount + "]";
	}
}
