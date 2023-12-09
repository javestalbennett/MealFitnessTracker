package MealFitnessPlanPkg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MealFitnessPlanPkg.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
}