package com.example.jazdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
    @ManyToOne
    private Elixir elixir;

    public ElixirInventor(String firstName, String lastName, Elixir elixir) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.elixir = elixir;
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

    public Elixir getElixir() {
        return elixir;
    }

    public void setElixir(Elixir elixir) {
        this.elixir = elixir;
    }
}
