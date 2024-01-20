package com.example.jazdata.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class JazDataCatalog implements ICatalogData {
    private final ElixirRepository elixirs;
    private final IngredientRepository ingredients;
    private final ElixirInventorRepository inventors;

    public JazDataCatalog(ElixirRepository elixirs, IngredientRepository ingredients, ElixirInventorRepository inventors) {
        this.elixirs = elixirs;
        this.ingredients = ingredients;
        this.inventors = inventors;
    }

    @Override
    public ElixirRepository getElixirs() {
        return elixirs;
    }

    @Override
    public IngredientRepository getIngredients() {
        return ingredients;
    }

    @Override
    public ElixirInventorRepository getElixirInventors() {
        return inventors;
    }
}
