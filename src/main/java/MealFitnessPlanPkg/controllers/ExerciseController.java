package MealFitnessPlanPkg.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import MealFitnessPlanPkg.MealFitnessPlanPkg.beans.Exercise;

/**
 * @author Itsal - Quinn Birdsley
 * CIS175 - Fall 2021
 * Nov 27, 2023
 */

/**
 * 
 * Explanation: This controller handles all requests related to exercises. It
 * has five methods:
 * 
 * getAllExercises(): This method returns a list of all exercises in the system.
 * 
 * 
 * 
 * getExerciseById(int exerciseId): This method returns an exercise with the
 * specified ID.
 * 
 * 
 * 
 * createExercise(Exercise exercise): This method creates a new exercise and
 * returns it.
 * 
 * 
 * 
 * updateExercise(int exerciseId, Exercise exercise): This method updates an
 * existing exercise with the specified ID and returns it.
 * 
 * 
 * 
 * deleteExercise(int exerciseId): This method deletes an exercise with the
 * specified ID.
 */
@Controller
@RequestMapping("/exercises")
public class ExerciseController {

	private final ExerciseService exerciseService;

	public ExerciseController(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	@GetMapping
	public List<Exercise> getAllExercises() {
		return exerciseService.findAllExercises();
	}

	@GetMapping("/{exerciseId}")
	public Exercise getExerciseById(@PathVariable int exerciseId) {
		return exerciseService.findExerciseById(exerciseId);
	}

	@PostMapping
	public Exercise createExercise(@RequestBody Exercise exercise) {
		return exerciseService.createExercise(exercise);
	}

	@PutMapping("/{exerciseId}")
	public Exercise updateExercise(@PathVariable int exerciseId, @RequestBody Exercise exercise) {
		return exerciseService.updateExercise(exerciseId, exercise);
	}

	@DeleteMapping("/{exerciseId}")
	public void deleteExercise(@PathVariable int exerciseId) {
		exerciseService.deleteExercise(exerciseId);
	}
}