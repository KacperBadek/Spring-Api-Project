package com.example.jazwebapi.controllers;

import com.example.jazwebapi.contract.IngredientDto;
import com.example.jazwebapi.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping("all")
    public ResponseEntity<List<IngredientDto>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<IngredientDto> getIngredientById(@PathVariable UUID id) {
        return ResponseEntity.ok(ingredientService.getIngredientById(id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<UUID> deleteIngredientById(@PathVariable UUID id) {
        ingredientService.deleteIngredientById(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping
    public ResponseEntity<UUID> saveIngredient(@RequestBody IngredientDto ingredientDto) {
        var id = ingredientService.saveIngredient(ingredientDto);
        return ResponseEntity.ok(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<UUID> updateIngredient(@PathVariable UUID id, @RequestBody IngredientDto ingredientDto) {
        ingredientService.updateIngredient(id, ingredientDto);
        return ResponseEntity.ok(id);
    }

}
