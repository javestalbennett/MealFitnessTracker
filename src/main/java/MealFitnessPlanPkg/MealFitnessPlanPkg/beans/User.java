package MealFitnessPlanPkg.beans;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Exercise> exercises = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Meal> meals = new ArrayList<>();

    // Default no-args constructor
    public User() {
    }

    // Constructor
    public User(String userName) {
        this.userName = userName;
    }

    // Getters and setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        StringBuilder userData = new StringBuilder();
        userData.append("User [userName=").append(userName).append(", userId=").append(userId).append("] \n");

        // add exercises to user data string
        for (Exercise exercise : exercises) {
            userData.append("Exercise [exerciseName=").append(exercise.getExerciseName())
                    .append(", amount=").append(exercise.getAmount()).append("] \n");
        }

        // add meals to user data string
        for (Meal meal : meals) {
            userData.append("Meal [mealName=").append(meal.getMealName())
                    .append(", amount=").append(meal.getCalories()).append("] \n");
        }

        return userData.toString();
    }
}
