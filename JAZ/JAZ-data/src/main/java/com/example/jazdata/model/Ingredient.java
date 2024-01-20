package com.example.jazdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Elixir> elixirs = new ArrayList<>();

    public Ingredient(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Elixir> getElixirs() {
        return elixirs;
    }

    public void setElixirs(List<Elixir> elixirs) {
        this.elixirs = elixirs;
    }
}
