package MealFitnessPlanPkg.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import MealFitnessPlanPkg.MealFitnessPlanPkg.beans.User;

/**
 * @author Itsal - Quinn Birdsley
 * CIS175 - Fall 2021
 * Nov 27, 2023
 */

/**
 * 
 * Explanation: This controller handles all requests related to users. It has
 * five methods:
 * 
 * getAllUsers(): This method returns a list of all users in the system.
 * 
 * 
 * 
 * getUserById(int userId): This method returns a user with the specified ID.
 * 
 * 
 * 
 * createUser(User user): This method creates a new user and returns it.
 * 
 * 
 * 
 * updateUser(int userId, User user): This method updates an existing user with
 * the specified ID and returns it.
 * 
 * 
 * 
 * deleteUser(int userId): This method deletes a user with the specified ID.
 */
@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable int userId) {
		return userService.findUserById(userId);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User user) {
		return userService.updateUser(userId, user);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
	}
}
