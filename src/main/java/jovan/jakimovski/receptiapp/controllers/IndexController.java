package jovan.jakimovski.receptiapp.controllers;

import jovan.jakimovski.receptiapp.domain.Category;
import jovan.jakimovski.receptiapp.domain.UnitOfMeasure;
import jovan.jakimovski.receptiapp.repositories.CategoryRepository;
import jovan.jakimovski.receptiapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/index","/index/"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional =  unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id="+categoryOptional.get().getId());
        System.out.println("UnitOfMeasure id="+unitOfMeasureOptional.get().getId());

        return "index";
    }
}
