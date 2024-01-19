package com.example.jazwebapi.controllers;

import com.example.jazwebapi.contract.ElixirInventorDto;
import com.example.jazwebapi.services.ElixirInventorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/inventors")
@RequiredArgsConstructor
public class ElixirInventorController {
    private final ElixirInventorService elixirInventorService;

    @GetMapping
    public ResponseEntity<List<ElixirInventorDto>> getAllInventors() {
        return ResponseEntity.ok(elixirInventorService.getAllInventors());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ElixirInventorDto> getInventorById(@PathVariable UUID id) {
        return ResponseEntity.ok(elixirInventorService.getInventorById(id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<UUID> deleteInventorById(@PathVariable UUID id) {
        elixirInventorService.deleteInventorById(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping(path = "add")
    public ResponseEntity<UUID> saveInventor(@RequestBody ElixirInventorDto elixirInventorDto) {
        var id = elixirInventorService.saveInventor(elixirInventorDto);
        return ResponseEntity.ok(id);
    }

    @PutMapping(path = "{id}/update")
    public ResponseEntity<UUID> updateInventor(@PathVariable UUID id, @RequestBody ElixirInventorDto elixirInventorDto) {
        elixirInventorService.updateInventor(id, elixirInventorDto);
        return ResponseEntity.ok(id);
    }

}
