package com.example.jazwebapi.services;

import com.example.jazdata.model.Ingredient;
import com.example.jazdata.repositories.ICatalogData;
import com.example.jazwebapi.contract.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final ICatalogData db;

    private IngredientDto getIngredientDto(Ingredient ingredient) {
        IngredientDto dto = new IngredientDto();
        dto.setId(ingredient.getId());
        dto.setName(ingredient.getName());

        return dto;
    }

    public List<IngredientDto> getAllIngredients() {
        return db.getIngredients().findAll().stream().map(this::getIngredientDto).toList();
    }

    public IngredientDto getIngredientById(UUID id) {
        return db.getIngredients().findById(id).map(this::getIngredientDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient with this id: " + id + " doesn't exists!"));
    }

    public void deleteIngredientById(UUID id) {
        Optional<Ingredient> ingredient = db.getIngredients().findById(id);

        if (ingredient.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient with this id: " + id + " doesn't exists!");
        else db.getIngredients().deleteById(id);

    }

    public UUID saveIngredient(IngredientDto dto) {
        Optional<Ingredient> check = db.getIngredients().findByName(dto.getName());
        if(check.isPresent()) throw new ResponseStatusException(HttpStatus.CONFLICT, "Ingredient with this name: " + dto.getName() + " already exists!");

        var ingredient = new Ingredient(dto.getName());

        db.getIngredients().save(ingredient);
        return ingredient.getId();
    }

    public void updateIngredient(UUID id, IngredientDto dto) {
        Ingredient ingredient = db.getIngredients().findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient with this id: " + id + " doesn't exists!"));

        ingredient.setName(dto.getName());
        db.getIngredients().save(ingredient);
    }

}
