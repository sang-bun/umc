package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Category;

public interface FoodCategoryRepository extends JpaRepository<Category,Long> {
}
