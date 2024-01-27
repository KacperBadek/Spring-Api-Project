package com.example.jazelixirsupdater.mappers;

import com.example.jazdata.model.Elixir;
import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.model.Ingredient;
import com.example.jazelixirsclient.contract.ElixirDto;
import com.example.jazelixirsclient.contract.ElixirInventorDto;
import com.example.jazelixirsclient.contract.IngredientDto;

public interface ICatalogMappers {

    IMapEntities<ElixirDto, Elixir> forElixir();

    IMapEntities<IngredientDto, Ingredient> forIngredient();

    IMapEntities<ElixirInventorDto, ElixirInventor> forInventor();

}
