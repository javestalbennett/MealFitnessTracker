package MealFitnessPlanPkg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import MealFitnessPlanPkg.Repository.ExerciseRepository;
import MealFitnessPlanPkg.Repository.MealRepository;
import MealFitnessPlanPkg.Repository.UserRepository;
import MealFitnessPlanPkg.beans.Exercise;
import MealFitnessPlanPkg.beans.User;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    @GetMapping("/all")
    public String viewAllUsers(Model model) {
        
        List<User> allUsers = userRepository.findAll();
        List<User> userMeals = userRepository.findAll();
        List<Exercise> userExercises = exerciseRepository.findAll();

        model.addAttribute("user", editUser(0, null));
        model.addAttribute("myMeals", userMeals);
        model.addAttribute("myExercises", userExercises);

        return "ViewAll";
    }

    @GetMapping("/input")
    public String createUser(Model model) {
        User myUser = new User();
        exerciseRepository.findAll().isEmpty();
        mealRepository.findAll().isEmpty();
        model.addAttribute("myMeals", mealRepository.findAll());
        model.addAttribute("myExercises", exerciseRepository.findAll());
        model.addAttribute("newMyUser", myUser);
        return "addUsers";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        User myUser = userRepository.findById(id).orElse(null);
        System.out.println("ITEM TO EDIT: " + myUser.toString());
        model.addAttribute("newMyUser", myUser);
        return "addUsers";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("newMyUser") User myUser, Model model) {
        myUser.setUserId(id);
        userRepository.save(myUser);
        return "viewAllUsers";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User myUser = userRepository.findById(id).orElse(null);
        userRepository.delete(myUser);
        return viewAllUsers(model);
    }
    
    public String submitUser(@ModelAttribute("newMyUser") User myUser, Model model) {
        userRepository.save(myUser);
        return "addUsers";
    }
}
