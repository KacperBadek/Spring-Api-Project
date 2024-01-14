package com.example.jazdata.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Elixir {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String effect;
    private String sideEffects;
    private String characteristics;
    private String time;
    @Enumerated(EnumType.STRING)
    private ElixirDifficulty difficulty;
    @OneToMany(mappedBy = "elixir", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();
    @OneToMany(mappedBy = "elixir", cascade = CascadeType.ALL)
    private List<ElixirInventor> inventors = new ArrayList<>();
    private String manufacturer;

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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ElixirDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(ElixirDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<ElixirInventor> getInventors() {
        return inventors;
    }

    public void setInventors(List<ElixirInventor> inventors) {
        this.inventors = inventors;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
