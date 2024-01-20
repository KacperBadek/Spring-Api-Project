package com.example.jazdata;

import com.example.jazdata.model.Elixir;
import com.example.jazdata.model.ElixirDifficulty;
import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.model.Ingredient;
import com.example.jazdata.repositories.ICatalogData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@EnableJpaRepositories
@SpringBootApplication
public class JazDataApplication implements CommandLineRunner {

    private final ICatalogData dataCatalog;

    public JazDataApplication(ICatalogData dataCatalog) {
        this.dataCatalog = dataCatalog;
    }

    public static void main(String[] args) {
        SpringApplication.run(JazDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Elixir elixir = new Elixir();
//        elixir.setName("Invisibility potion");
//        elixir.setEffect("Makes you invisible");
//        elixir.setSideEffects("You smell bad");
//        elixir.setCharacteristics("Green potion");
//        elixir.setTime("5 minuts");
//        elixir.setDifficulty(ElixirDifficulty.Beginner);
//
//        Ingredient ingredient1 = new Ingredient("Garlic");
//        Ingredient ingredient2 = new Ingredient("Cheese");
//        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);
//
//        ElixirInventor inventor = new ElixirInventor("Kacper", "Badek");
//        List<ElixirInventor> inventors = Collections.singletonList(inventor);
//
//        elixir.setIngredients(ingredients);
//        elixir.setInventors(inventors);
//        ingredient1.getElixirs().add(elixir);
//        ingredient2.getElixirs().add(elixir);
//        inventor.getElixirs().add(elixir);
//
//        dataCatalog.getElixirs().save(elixir);
//        dataCatalog.getIngredients().save(ingredient1);
//        dataCatalog.getIngredients().save(ingredient2);
//        dataCatalog.getElixirInventors().save(inventor);
    }
}
