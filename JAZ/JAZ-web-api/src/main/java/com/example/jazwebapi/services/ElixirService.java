package com.example.jazwebapi.services;

import com.example.jazdata.model.Elixir;
import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.model.Ingredient;
import com.example.jazdata.repositories.ICatalogData;
import com.example.jazwebapi.contract.ElixirDto;
import com.example.jazwebapi.contract.ElixirInventorDto;
import com.example.jazwebapi.contract.IngredientDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return db.getElixirs().findById(id).map(this::getElixirDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Elixir with this id: " + id + " doesn't exists!"));
    }

    public void deleteElixirById(UUID id) {
        Optional<Elixir> elixir = db.getElixirs().findById(id);

        if (elixir.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elixir with this id: " + id + " doesn't exists!");
        else db.getElixirs().deleteById(id);
    }

    public List<IngredientDto> getElixirIngredientsById(UUID id) {
        Optional<Elixir> elixirOptional = db.getElixirs().findById(id);

        if (elixirOptional.isPresent()) {
            Elixir elixir = elixirOptional.get();
            List<Ingredient> ingredientList = elixir.getIngredients();

            return ingredientList.stream().map(ingredient -> {
                var dto = new IngredientDto();
                dto.setName(ingredient.getName());
                return dto;
            }).toList();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elixir with this id: " + id + " doesn't exists!");
        }
    }

    //        List<Ingredient> ingredientList = db.getIngredients().findAll().stream().filter(ingredient ->
//                ingredient.getElixir().getId().equals(id)).toList();
//
//        return ingredientList.stream().map(ingredient -> {
//            var dto = new IngredientDto();
//            dto.setName(ingredient.getName());
//            return dto;
//        }).toList();

    public List<ElixirInventorDto> getElixirInventorsById(UUID id) {
        Optional<Elixir> elixirOptional = db.getElixirs().findById(id);

        if (elixirOptional.isPresent()) {
            Elixir elixir = elixirOptional.get();
            List<ElixirInventor> inventorList = elixir.getInventors();

            return inventorList.stream().map(inventor -> {
                var dto = new ElixirInventorDto();
                dto.setFirstName(inventor.getFirstName());
                dto.setLastName(inventor.getLastName());
                return dto;
            }).toList();

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elixir with this id: " + id + " doesn't exists!");
        }
    }

    public UUID saveElixir(ElixirDto dto) {

        Optional<Elixir> check = db.getElixirs().findByName(dto.getName());

        if(check.isPresent()) throw new ResponseStatusException(HttpStatus.CONFLICT, "Elixir with this name: " +dto.getName() + " already exists!");

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
        db.getElixirs().save(elixir);
    }

    public void saveIngredientById(UUID elixirId, IngredientDto dto) {
        var ingredient = new Ingredient(dto.getName());
        var elixir = db.getElixirs().findById(elixirId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Elixir with this id: " + elixirId + " doesn't exists!"));

        elixir.getIngredients().add(ingredient);
        ingredient.getElixirs().add(elixir);

        db.getIngredients().save(ingredient);
    }

    public void saveInventorById(UUID elixirId, ElixirInventorDto dto) {
        var inventor = new ElixirInventor(dto.getFirstName(), dto.getLastName());
        var elixir = db.getElixirs().findById(elixirId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Elixir with this id: " + elixirId + " doesn't exists!"));

        elixir.getInventors().add(inventor);
        inventor.getElixirs().add(elixir);

        db.getElixirInventors().save(inventor);
    }

}
