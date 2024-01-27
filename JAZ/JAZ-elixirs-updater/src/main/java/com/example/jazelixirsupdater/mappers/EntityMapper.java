package com.example.jazelixirsupdater.mappers;

import com.example.jazdata.model.Elixir;
import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.model.Ingredient;
import com.example.jazelixirsclient.contract.ElixirDto;
import com.example.jazelixirsclient.contract.ElixirInventorDto;
import com.example.jazelixirsclient.contract.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityMapper implements ICatalogMappers {

    private final IMapEntities<ElixirDto, Elixir> forElixir;

    private final IMapEntities<IngredientDto, Ingredient> forIngredient;

    private final IMapEntities<ElixirInventorDto, ElixirInventor> forInventor;

    @Override
    public IMapEntities<ElixirDto, Elixir> forElixir() {
        return forElixir;
    }

    @Override
    public IMapEntities<IngredientDto, Ingredient> forIngredient() {
        return forIngredient;
    }

    @Override
    public IMapEntities<ElixirInventorDto, ElixirInventor> forInventor() {
        return forInventor;
    }
}
