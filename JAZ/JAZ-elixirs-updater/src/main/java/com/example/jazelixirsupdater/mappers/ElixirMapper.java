package com.example.jazelixirsupdater.mappers;

import com.example.jazdata.model.Elixir;
import com.example.jazelixirsclient.contract.ElixirDto;
import org.springframework.stereotype.Component;

@Component
public class ElixirMapper implements IMapEntities<ElixirDto, Elixir> {
    @Override
    public Elixir map(ElixirDto elixirDto) {
        return map(elixirDto, new Elixir());
    }

    @Override
    public Elixir map(ElixirDto elixirDto, Elixir elixir) {
        elixir.setName(elixirDto.getName());
        elixir.setEffect(elixirDto.getEffect());
        elixir.setSideEffects(elixirDto.getSideEffects());
        elixir.setCharacteristics(elixirDto.getCharacteristics());
        elixir.setTime(elixirDto.getTime());
        elixir.setDifficulty(elixirDto.getDifficulty());
        elixir.setManufacturer(elixirDto.getManufacturer());

        return elixir;
    }
}
