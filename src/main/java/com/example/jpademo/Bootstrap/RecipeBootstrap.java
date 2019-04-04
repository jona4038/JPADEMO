package com.example.jpademo.Bootstrap;

import com.example.jpademo.Model.Ingredient;
import com.example.jpademo.Model.Notes;
import com.example.jpademo.Model.Recipe;
import com.example.jpademo.Model.UnitOfMeasure;
import com.example.jpademo.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RecipeRepository recipeRepository;


    private List<Recipe> createRecipes(){
        List<Recipe> recipes = new ArrayList<>();
        Recipe r1 = new Recipe();
        r1.setDescription("Perfect Guacamole");

        Notes notes = new Notes();
        notes.setNotes("Avocado, hvidløg, citron, spidskommen, creme-fraiche, salt, peber, tomatskal");
        notes.setRecipe(r1);
        r1.setNotes(notes);
        recipes.add(r1);




        Ingredient ingredient = new Ingredient();
        ingredient.setName("Avocado");
        ingredient.setGrams(BigDecimal.valueOf(500));
        r1.getIngredients().add(ingredient);
        ingredient.setRecipe(r1);





        recipes.add(r1);

        return recipes;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(createRecipes());
    }
}
