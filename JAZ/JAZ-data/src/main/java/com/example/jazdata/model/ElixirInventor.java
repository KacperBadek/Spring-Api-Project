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
public class ElixirInventor {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Elixir> elixirs = new ArrayList<>();

    public ElixirInventor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Elixir> getElixirs() {
        return elixirs;
    }

    public void setElixirs(List<Elixir> elixirs) {
        this.elixirs = elixirs;
    }
}
