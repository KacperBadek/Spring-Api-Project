package com.example.jazelixirsupdater.updater;

import com.example.jazdata.model.Elixir;
import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.model.Ingredient;
import com.example.jazdata.repositories.ICatalogData;
import com.example.jazelixirsclient.contract.ElixirDto;
import com.example.jazelixirsclient.contract.IngredientDto;
import com.example.jazelixirsclient.elixirsclient.IElixirsClient;
import com.example.jazelixirsupdater.mappers.ICatalogMappers;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElixirsUpdater implements IUpdateElixirs {
    private final ICatalogData db;
    private final IElixirsClient elixirsClient;
    private final ICatalogMappers entityMapper;

    @Override
    public void updateAll() {
        List<ElixirDto> elixirs = Arrays.asList(elixirsClient.getAllElixirs());

        for (ElixirDto elixir : elixirs) {
            saveElixir(elixir);
        }
    }

    @Transactional
    public void saveElixir(ElixirDto dto) {
        Optional<Elixir> optionalElixir = db.getElixirs().findByName(dto.getName());
        if (optionalElixir.isEmpty()) {
            var elixirEntity = entityMapper.forElixir().map(dto);
            addEntitiesToElixir(dto, elixirEntity);

            db.getElixirs().save(elixirEntity);
        }
    }

    public void addEntitiesToElixir(ElixirDto elixirDto, Elixir elixirEntity) {
        elixirDto.getIngredients().forEach(ingredientDto -> {
            Ingredient ingredient = entityMapper.forIngredient().map(ingredientDto);
            Optional<Ingredient> optional = db.getIngredients().findByName(ingredientDto.getName());

            if (optional.isPresent()) {
                ingredient = optional.get();
            }

            ingredient.getElixirs().add(elixirEntity);
            elixirEntity.getIngredients().add(ingredient);
        });

        elixirDto.getInventors().forEach(elixirInventorDto -> {
            ElixirInventor inventor = entityMapper.forInventor().map(elixirInventorDto);
            Optional<ElixirInventor> optional = db.getElixirInventors().findByFirstNameAndLastName(elixirInventorDto.getFirstName(), elixirInventorDto.getLastName());

            if (optional.isPresent()) {
                inventor = optional.get();
            }

            inventor.getElixirs().add(elixirEntity);
            elixirEntity.getInventors().add(inventor);
        });
    }

}
