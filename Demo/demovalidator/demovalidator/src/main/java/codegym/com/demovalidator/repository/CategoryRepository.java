package codegym.com.demovalidator.repository;

import codegym.com.demovalidator.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
