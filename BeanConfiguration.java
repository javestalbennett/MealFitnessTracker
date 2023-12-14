/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Dec 14, 2023
*/
package MealFitnessPlanPkg.controller;
import java.util.ArrayList;

import MealFitnessPlanPkg.beans.*;

/**
 * 
 */
public class BeanConfiguration {
	
	public Exercise exercise()
	{
		// configure bean
		Exercise bean = new Exercise();
		bean.setExerciseName("Jumping jacks");
		bean.setAmount("5x10");
		return bean;
	}
	
	public Meal meal() 
	{
		// configure bean
		Meal bean = new Meal();
		bean.setCalories(600);
		bean.setMealName("Chicken breast");
		return bean;
	}
	
	public User user() 
	{
		// create meal list and add meal object
		Meal m = new Meal();
		m.setCalories(600);
		m.setMealName("Chicken breast");
		ArrayList<Meal> mealList = new ArrayList();
		mealList.add(m);
		
		// create exercise list and add exercise object
		Exercise e = new Exercise();
		e.setExerciseName("Jumping jacks");
		e.setAmount("5x10");
		ArrayList<Exercise> exerciseList = new ArrayList();
		exerciseList.add(e);
		
		// configure bean
		User bean = new User();
		bean.setUserName("Jane");
		bean.setMeals(mealList);
		bean.setExercises(exerciseList);
		return bean;
	}

}
