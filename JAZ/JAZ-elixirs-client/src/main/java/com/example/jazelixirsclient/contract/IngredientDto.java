package com.example.jazelixirsclient.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class IngredientDto {
    private UUID id;
    private String name;
    private List<ElixirDto> elixirs = new ArrayList<>();
}
