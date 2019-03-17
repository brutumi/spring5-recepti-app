package jovan.jakimovski.receptiapp.services;

import jovan.jakimovski.receptiapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
