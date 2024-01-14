package com.example.jazdata.repositories;

import com.example.jazdata.model.Elixir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ElixirRepository extends JpaRepository<Elixir, UUID> {
}
