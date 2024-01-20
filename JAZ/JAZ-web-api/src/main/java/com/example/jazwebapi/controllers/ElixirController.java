package com.example.jazwebapi.controllers;

import com.example.jazwebapi.contract.ElixirDto;
import com.example.jazwebapi.contract.ElixirInventorDto;
import com.example.jazwebapi.contract.IngredientDto;
import com.example.jazwebapi.services.ElixirInventorService;
import com.example.jazwebapi.services.ElixirService;
import com.example.jazwebapi.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller()
@RequestMapping("/api/v1/elixirs")
@RequiredArgsConstructor
public class ElixirController {
    private final ElixirService elixirService;

    @GetMapping("/all")
    public ResponseEntity<List<ElixirDto>> getAllElixirs() {
        return ResponseEntity.ok(elixirService.getAllElixirs());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ElixirDto> getElixirById(@PathVariable UUID id) {
        return ResponseEntity.ok(elixirService.getElixirById(id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<UUID> deleteElixirById(@PathVariable UUID id) {
        elixirService.deleteElixirById(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping
    public ResponseEntity<UUID> saveElixir(@RequestBody ElixirDto elixirDto) {
        var id = elixirService.saveElixir(elixirDto);
        return ResponseEntity.ok(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<UUID> updateElixir(@PathVariable UUID id, @RequestBody ElixirDto elixirDto) {
        elixirService.updateElixir(id, elixirDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping(path = "{id}/ingredients")
    public ResponseEntity<List<IngredientDto>> getElixirIngredientsById(@PathVariable UUID id) {
        return ResponseEntity.ok(elixirService.getElixirIngredientsById(id));
    }

    @GetMapping(path = "{id}/inventors")
    public ResponseEntity<List<ElixirInventorDto>> getElixirInventorsById(@PathVariable UUID id) {
        return ResponseEntity.ok(elixirService.getElixirInventorsById(id));
    }

    @PostMapping(path = "{elixirId}/ingredient")
    public ResponseEntity<UUID> saveIngredientById(@PathVariable UUID elixirId, @RequestBody IngredientDto ingredientDto) {
        elixirService.saveIngredientById(elixirId, ingredientDto);
        return ResponseEntity.ok(elixirId);
    }

    @PostMapping(path = "{elixirId}/inventor")
    public ResponseEntity<UUID> saveInventorById(@PathVariable UUID elixirId, @RequestBody ElixirInventorDto inventorDto) {
        elixirService.saveInventorById(elixirId, inventorDto);
        return ResponseEntity.ok(elixirId);
    }

}