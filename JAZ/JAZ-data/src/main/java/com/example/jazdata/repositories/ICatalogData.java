package com.example.jazdata.repositories;

import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.model.Ingredient;

public interface ICatalogData {
    ElixirRepository getElixirs();

    IngredientRepository getIngredients();

    ElixirInventorRepository getElixirInventors();
}
