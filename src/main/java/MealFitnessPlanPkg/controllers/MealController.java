package MealFitnessPlanPkg.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import MealFitnessPlanPkg.MealFitnessPlanPkg.beans.Meal;

/**
 * @author Itsal - Quinn Birdsley
 * CIS175 - Fall 2021
 * Nov 27, 2023
 */

/**
 * This controller handles all requests related to meals. It has five methods:
 * 
 * getAllMeals(): This method returns a list of all meals in the system.
 * 
 * 
 * 
 * getMealById(int mealId): This method returns a meal with the specified ID.
 * 
 * 
 * 
 * createMeal(Meal meal): This method creates a new meal and returns it.
 * 
 * 
 * 
 * updateMeal(int mealId, Meal meal): This method updates an existing meal with
 * the specified ID and returns it.
 * 
 * 
 * 
 * deleteMeal(int mealId): This method deletes a meal with the specified ID.
 */
@Controller
@RequestMapping("/meals")
public class MealController {

	private final MealService mealService;

	public MealController(MealService mealService) {
		this.mealService = mealService;
	}

	@GetMapping
	public List<Meal> getAllMeals() {
		return mealService.findAllMeals();
	}

	@GetMapping("/{mealId}")
	public Meal getMealById(@PathVariable int mealId) {
		return mealService.findMealById(mealId);
	}

	@PostMapping
	public Meal createMeal(@RequestBody Meal meal) {
		return mealService.createMeal(meal);
	}

	@PutMapping("/{mealId}")
	public Meal updateMeal(@PathVariable int mealId, @RequestBody Meal meal) {
		return mealService.updateMeal(mealId, meal);
	}

	@DeleteMapping("/{mealId}")
	public void deleteMeal(@PathVariable int mealId) {
		mealService.deleteMeal(mealId);
	}
}