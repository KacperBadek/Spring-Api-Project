package com.example.jazelixirsclient.contract;

import com.example.jazdata.model.ElixirDifficulty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ElixirDto {
    private UUID id;
    private String name;
    private String effect;
    @JsonProperty("side_effects")
    private String sideEffects;
    private String characteristics;
    private String time;
    private ElixirDifficulty difficulty;
    private List<IngredientDto> ingredients = new ArrayList<>();
    private List<ElixirInventorDto> inventors = new ArrayList<>();
    private String manufacturer;

}
