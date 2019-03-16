package jovan.jakimovski.receptiapp.repositories;

import jovan.jakimovski.receptiapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
