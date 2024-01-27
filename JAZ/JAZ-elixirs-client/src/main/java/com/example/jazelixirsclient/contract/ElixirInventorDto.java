package com.example.jazelixirsclient.contract;

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
public class ElixirInventorDto {
    private UUID id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private List<ElixirDto> elixirs = new ArrayList<>();
}
