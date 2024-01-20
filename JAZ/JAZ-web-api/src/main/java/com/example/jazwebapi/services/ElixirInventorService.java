package com.example.jazwebapi.services;

import com.example.jazdata.model.ElixirInventor;
import com.example.jazdata.repositories.ICatalogData;
import com.example.jazwebapi.contract.ElixirInventorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ElixirInventorService {
    private final ICatalogData db;

    private ElixirInventorDto getElixirInventorDto(ElixirInventor elixirInventor) {
        ElixirInventorDto dto = new ElixirInventorDto();
        dto.setId(elixirInventor.getId());
        dto.setFirstName(elixirInventor.getFirstName());
        dto.setLastName(elixirInventor.getLastName());
        return dto;
    }

    public List<ElixirInventorDto> getAllInventors() {
        return db.getElixirInventors().findAll().stream().map(this::getElixirInventorDto).toList();
    }

    public ElixirInventorDto getInventorById(UUID id) {
        return db.getElixirInventors().findById(id).map(this::getElixirInventorDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventor with this id: " + id + " doesn't exists!"));
    }

    public void deleteInventorById(UUID id) {
        Optional<ElixirInventor> inventor = db.getElixirInventors().findById(id);

        if (inventor.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventor with this id: " + id + " doesn't exists!");
        else db.getElixirInventors().deleteById(id);
    }

    public UUID saveInventor(ElixirInventorDto dto) {
        Optional<ElixirInventor> check = db.getElixirInventors().findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
        if (check.isPresent()) throw new ResponseStatusException(HttpStatus.CONFLICT, "This inventor already exists!");

        var inventor = new ElixirInventor(dto.getFirstName(), dto.getLastName());

        db.getElixirInventors().save(inventor);
        return inventor.getId();
    }

    public void updateInventor(UUID id, ElixirInventorDto dto) {
        ElixirInventor inventor = db.getElixirInventors().findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventor with this id: " + id + " doesn't exists!"));

        inventor.setFirstName(dto.getFirstName());
        inventor.setLastName(dto.getLastName());
        db.getElixirInventors().save(inventor);
    }

}
