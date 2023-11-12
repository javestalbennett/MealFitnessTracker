/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Nov 12, 2023
*/
package MealFitnessPlanPkg.MealFitnessPlanPkg.beans;

import java.util.ArrayList;

import jakarta.persistence.Embeddable;

/**
 * 
 */
@Embeddable
public class User {
	public int userId;
	public String userName;
	public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	public ArrayList<Meal> meals = new ArrayList<Meal>();
	
	// default no-args constructor
	public User() {
	}
	
	// constructor
	public User(int userId, String userName, ArrayList<Exercise> exercises, ArrayList<Meal> meals) {
	}
	
	// getters and setters
	

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the exercises
	 */
	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	/**
	 * @param exercises the exercises to set
	 */
	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

	/**
	 * @return the meals
	 */
	public ArrayList<Meal> getMeals() {
		return meals;
	}

	/**
	 * @param meals the meals to set
	 */
	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}

	@Override
	public String toString() {
		String userData;
		userData = "User [userName=" + userName + ", userId=" + userId + "] \n";
		
		// add exercises to user data string
		for(int i = 0; i < exercises.size(); i++)
		{
			userData += "Exercise [exerciseName=" + exercises.get(i).getExerciseName() + 
					", amount=" + exercises.get(i).getAmount() + "] \n";
		}
		
		// add meals to user data string
		for(int i = 0; i < meals.size(); i++)
		{
			userData += "Meal [mealName=" + meals.get(i).getMealName() + 
					", amount=" + meals.get(i).getCalories() + "] \n";
		}
		
		
		return userData;
	}
}
