package com.example.jazwebapi.services;

import com.example.jazdata.model.Elixir;
import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.model.Ingredient;
import com.example.jazdata.repositories.ICatalogData;
import com.example.jazwebapi.contract.ElixirDto;
import com.example.jazwebapi.contract.ElixirInventorDto;
import com.example.jazwebapi.contract.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ElixirService {
    private final ICatalogData db;

    private ElixirDto getElixirDto(Elixir elixir) {
        ElixirDto dto = new ElixirDto();
        dto.setId(elixir.getId());
        dto.setName(elixir.getName());
        dto.setEffect(elixir.getEffect());
        dto.setSideEffects(elixir.getSideEffects());
        dto.setCharacteristics(elixir.getCharacteristics());
        dto.setTime(elixir.getTime());
        dto.setDifficulty(elixir.getDifficulty());

        return dto;
    }

    public List<ElixirDto> getAllElixirs() {
        return db.getElixirs().findAll().stream().map(this::getElixirDto).toList();
    }

    public ElixirDto getElixirById(UUID id) {
        return db.getElixirs().findById(id).map(this::getElixirDto).orElseThrow(() -> new RuntimeException("Elixir with this id: " + id + " doesn't exists!"));
    }

    public void deleteElixirById(UUID id) {
        Optional<Elixir> elixir = db.getElixirs().findById(id);

        if (elixir.isEmpty()) throw new RuntimeException("Elixir with this id: " + id + " doesn't exists!");
        else db.getElixirs().deleteById(id);
    }

    public List<IngredientDto> getElixirIngredientsById(UUID id) {
        List<Ingredient> ingredientList = db.getIngredients().findAll().stream().filter(ingredient ->
                ingredient.getElixir().getId().equals(id)).toList();

        return ingredientList.stream().map(ingredient -> {
            var dto = new IngredientDto();
            dto.setName(ingredient.getName());
            return dto;
        }).toList();
    }

    public List<ElixirInventorDto> getElixirInventorsById(UUID id) {
        List<ElixirInventor> inventorList = db.getElixirInventors().findAll().stream().filter(elixirInventor ->
                elixirInventor.getElixir().getId().equals(id)).toList();

        return inventorList.stream().map(elixirInventor -> {
            var dto = new ElixirInventorDto();
            dto.setFirstName(elixirInventor.getFirstName());
            dto.setLastName(elixirInventor.getLastName());
            return dto;
        }).toList();
    }

    public UUID saveElixir(ElixirDto dto) {
        var elixir = new Elixir();
        elixir.setName(dto.getName());
        elixir.setEffect(dto.getEffect());
        elixir.setSideEffects(dto.getSideEffects());
        elixir.setCharacteristics(dto.getCharacteristics());
        elixir.setTime(dto.getTime());
        elixir.setDifficulty(dto.getDifficulty());

        db.getElixirs().save(elixir);
        return elixir.getId();
    }

    public void updateElixir(UUID id, ElixirDto elixirDto) {
        Elixir elixir = db.getElixirs().findById(id).orElseThrow(() -> new RuntimeException("Elixir with this id: " + id + " doesn't exists!"));

        elixir.setName(elixirDto.getName());
        elixir.setEffect(elixirDto.getEffect());
        elixir.setSideEffects(elixirDto.getSideEffects());
        elixir.setCharacteristics(elixirDto.getCharacteristics());
        elixir.setTime(elixirDto.getTime());
        elixir.setDifficulty(elixirDto.getDifficulty());
    }

}
