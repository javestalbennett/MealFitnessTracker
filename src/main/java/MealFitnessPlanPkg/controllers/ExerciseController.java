package MealFitnessPlanPkg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import MealFitnessPlanPkg.Repository.ExerciseRepository;
import MealFitnessPlanPkg.beans.Exercise;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @GetMapping("/all")
    public String viewAllExercise(Model model) {
        if (exerciseRepository.findAll().isEmpty()) {
            return createExercise(model);
        }

        model.addAttribute("myExercises", exerciseRepository.findAll());
        return "viewAll";
    }

    @GetMapping("/input")
    public String createExercise(Model model) {
        Exercise myExercise = new Exercise();
        model.addAttribute("newMyExercises", myExercise);
        return "inputExercise";
    }

    @GetMapping("/edit/{id}")
    public String editExercise(@PathVariable("id") long id, Model model) {
        Exercise myExercise = exerciseRepository.findById(id).orElse(new Exercise());
        System.out.println("ITEM TO EDIT: " + myExercise.toString());
        model.addAttribute("newMyExercises", myExercise);
        return "inputExercise";
    }

    @PostMapping("/update/{id}")
    public String updateExercise(@PathVariable("id") int id, Exercise myExercise, Model model) {
        myExercise.setId(id);
        exerciseRepository.save(myExercise);
        return "viewAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteExercise(@PathVariable("id") long id, Model model) {
        Exercise myExercise = exerciseRepository.findById(id).orElse(null);
        exerciseRepository.delete(myExercise);
        return viewAllExercise(model);
    }

    @PostMapping("/submit")
    public String submitExercise(@ModelAttribute("newMyExercises") Exercise myExercise, Model model) {
        exerciseRepository.save(myExercise);
        return "inputExercise";
    }
}