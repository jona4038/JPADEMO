package com.example.jpademo.Repository;

import com.example.jpademo.Model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {

    Optional<Recipe> findByDescription(String description);
}
