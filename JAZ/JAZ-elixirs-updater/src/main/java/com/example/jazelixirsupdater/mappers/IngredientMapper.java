package com.example.jazelixirsupdater.mappers;

import com.example.jazdata.model.Ingredient;
import com.example.jazelixirsclient.contract.IngredientDto;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper implements IMapEntities<IngredientDto, Ingredient> {
    @Override
    public Ingredient map(IngredientDto ingredientDto) {
        return map(ingredientDto, new Ingredient());
    }

    @Override
    public Ingredient map(IngredientDto ingredientDto, Ingredient ingredient) {
        ingredient.setName(ingredientDto.getName());

        return ingredient;
    }
}
