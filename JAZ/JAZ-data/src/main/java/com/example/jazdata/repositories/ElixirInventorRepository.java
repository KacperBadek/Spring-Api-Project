package com.example.jazdata.repositories;

import com.example.jazdata.model.ElixirInventor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ElixirInventorRepository extends JpaRepository<ElixirInventor, UUID> {
    Optional<ElixirInventor> findByFirstNameAndLastName(String first, String Last);
}
