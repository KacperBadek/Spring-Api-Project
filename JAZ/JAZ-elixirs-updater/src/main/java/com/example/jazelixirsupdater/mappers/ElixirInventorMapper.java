package com.example.jazelixirsupdater.mappers;

import com.example.jazdata.model.ElixirInventor;
import com.example.jazelixirsclient.contract.ElixirInventorDto;
import org.springframework.stereotype.Component;

@Component
public class ElixirInventorMapper implements IMapEntities<ElixirInventorDto, ElixirInventor> {
    @Override
    public ElixirInventor map(ElixirInventorDto elixirInventorDto) {
        return map(elixirInventorDto, new ElixirInventor());
    }

    @Override
    public ElixirInventor map(ElixirInventorDto elixirInventorDto, ElixirInventor elixirInventor) {
        elixirInventor.setFirstName(elixirInventorDto.getFirstName());
        elixirInventor.setLastName(elixirInventorDto.getLastName());

        return elixirInventor;
    }
}
