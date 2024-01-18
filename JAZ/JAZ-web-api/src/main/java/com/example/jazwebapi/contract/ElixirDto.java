package com.example.jazwebapi.contract;

import com.example.jazdata.model.ElixirDifficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class ElixirDto {

    private UUID id;
    private String name;
    private String effect;
    private String sideEffects;
    private String characteristics;
    private String time;
    private ElixirDifficulty difficulty;

}
