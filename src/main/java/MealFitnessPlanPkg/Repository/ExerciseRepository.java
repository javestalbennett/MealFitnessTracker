package MealFitnessPlanPkg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MealFitnessPlanPkg.beans.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
	
	
}
