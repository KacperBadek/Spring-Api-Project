package com.example.jazwebapi.services;

import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.repositories.ICatalogData;
import com.example.jazwebapi.contract.ElixirInventorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElixirInventorService {
    private final ICatalogData db;

    private ElixirInventorDto getElixirInventorDto(ElixirInventor elixirInventor) {
        ElixirInventorDto dto = new ElixirInventorDto();
        dto.setFirstName(elixirInventor.getFirstName());
        dto.setLastName(elixirInventor.getLastName());
        return dto;
    }

    public List<ElixirInventorDto> getAllInventors() {
        return db.getElixirInventors().findAll().stream().map(this::getElixirInventorDto).toList();
    }

    public ElixirInventorDto getInventorById(UUID id) {
        return db.getElixirInventors().findById(id).map(this::getElixirInventorDto).orElseThrow(() -> new RuntimeException("Inventor with this id: " + id + " doesn't exists!"));
    }

    public void deleteInventorById(UUID id) {
        Optional<ElixirInventor> inventor = db.getElixirInventors().findById(id);

        if (inventor.isEmpty()) throw new RuntimeException("Inventor with this id: " + id + " doesn't exists!");
        else db.getElixirInventors().deleteById(id);
    }

    public UUID saveInventor(ElixirInventorDto dto) {
        var inventor = new ElixirInventor();
        inventor.setFirstName(dto.getFirstName());
        inventor.setLastName(dto.getLastName());

        db.getElixirInventors().save(inventor);
        return inventor.getId();
    }

    public void updateInventor(UUID id, ElixirInventorDto dto) {
        ElixirInventor inventor = db.getElixirInventors().findById(id).orElseThrow(() -> new RuntimeException("Inventor with this id: " + id + " doesn't exists!"));

        inventor.setFirstName(dto.getFirstName());
        inventor.setLastName(dto.getLastName());
    }

}
