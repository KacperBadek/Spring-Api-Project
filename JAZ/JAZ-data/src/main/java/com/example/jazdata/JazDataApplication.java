package com.example.jazdata;

import com.example.jazdata.model.Elixir;
import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.model.Ingredient;
import com.example.jazdata.repositories.ICatalogData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        Elixir elixir = new Elixir();
        elixir.setName("Invisibility potion");
        elixir.setEffect("Makes you invisible");
        elixir.setSideEffects("You smell bad");

        Ingredient ingredient1 = new Ingredient("garlic", elixir);
        Ingredient ingredient2 = new Ingredient("cheese", elixir);
        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);

        ElixirInventor inventor = new ElixirInventor("Harry", "Potter", elixir);
        List<ElixirInventor> inventors = Collections.singletonList(inventor);

        elixir.setIngredients(ingredients);
        elixir.setInventors(inventors);
        dataCatalog.getElixirs().save(elixir);
    }
}
