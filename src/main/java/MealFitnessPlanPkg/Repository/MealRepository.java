package MealFitnessPlanPkg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MealFitnessPlanPkg.beans.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
	
	
}