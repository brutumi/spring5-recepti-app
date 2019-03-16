package jovan.jakimovski.receptiapp.repositories;

import jovan.jakimovski.receptiapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
