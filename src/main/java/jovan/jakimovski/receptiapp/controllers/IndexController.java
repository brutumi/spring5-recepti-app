package jovan.jakimovski.receptiapp.controllers;

import jovan.jakimovski.receptiapp.domain.Category;
import jovan.jakimovski.receptiapp.domain.UnitOfMeasure;
import jovan.jakimovski.receptiapp.repositories.CategoryRepository;
import jovan.jakimovski.receptiapp.repositories.UnitOfMeasureRepository;
import jovan.jakimovski.receptiapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/index","/index/"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
