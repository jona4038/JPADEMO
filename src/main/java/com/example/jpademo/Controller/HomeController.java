package com.example.jpademo.Controller;

import com.example.jpademo.Model.Recipe;
import com.example.jpademo.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/")
    public String home(){
        Optional<Recipe> recipe = recipeRepository.findByDescription("Perfect Guacamole");
        if(recipe.isPresent()){
            System.out.println("Fandt: " + recipe.get().getDescription());
        } else {
            System.out.println("Fandt ingen opskrift");
        }
        return "index";
    }

    @PostMapping("/opret")
    public String opretRecipe(Recipe recipe){
        recipeRepository.save(recipe);
        return "index";
    }

}
