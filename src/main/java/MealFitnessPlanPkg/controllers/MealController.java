package MealFitnessPlanPkg.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import MealFitnessPlanPkg.Repository.MealRepository;
import MealFitnessPlanPkg.beans.Meal;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @GetMapping("/all")
    public String viewAllMeals(Model model) {
        if (mealRepository.findAll().isEmpty()) {
            System.out.println("No meals found in the database.");
            return createMeal(model);
        }

        List<Meal> allMeals = mealRepository.findAll();
        System.out.println("Number of meals found: " + allMeals.size());

        model.addAttribute("myMeals", allMeals);
        return "ViewAll";
    }

    @GetMapping("/input")
    public String createMeal(Model model) {
        Meal myMeal = new Meal();
        model.addAttribute("newMyMeal", myMeal);
        return "inputMeal";
    }

    @GetMapping("/edit/{id}")
    public String editMeal(@PathVariable("id") long id, Model model) {
        Meal myMeal = mealRepository.findById(id).orElse(new Meal());
        System.out.println("ITEM TO EDIT: " + myMeal.toString());
        model.addAttribute("newMyMeal", myMeal);
        return "inputMeal";
    }

    @PostMapping("/update/{id}")
    public String updateMeal(@PathVariable("id") int id, Meal myMeal, Model model) {
        myMeal.setId(id);
        mealRepository.save(myMeal);
        return "ViewAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteMeal(@PathVariable("id") long id, Model model) {
        Meal myMeal = mealRepository.findById(id).orElse(null);
        mealRepository.delete(myMeal);
        return viewAllMeals(model);
    }
    
    @PostMapping("/submit")
    public String submitMeal(@ModelAttribute("newMyMeal") Meal myMeal, Model model) {
        mealRepository.save(myMeal);
        return "inputMeal";
    }
}