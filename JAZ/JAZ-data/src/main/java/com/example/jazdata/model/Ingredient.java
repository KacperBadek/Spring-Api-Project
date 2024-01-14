package com.example.jazdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @ManyToOne
    private Elixir elixir;

    public Ingredient(String name, Elixir elixir) {
        this.name = name;
        this.elixir = elixir;
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

    public Elixir getElixir() {
        return elixir;
    }

    public void setElixir(Elixir elixir) {
        this.elixir = elixir;
    }
}
