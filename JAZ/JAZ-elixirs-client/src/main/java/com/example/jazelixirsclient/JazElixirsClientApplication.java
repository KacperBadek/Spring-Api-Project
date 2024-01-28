package com.example.jazelixirsclient;

import com.example.jazdata.JazDataApplication;
import com.example.jazelixirsclient.contract.ElixirDto;
import com.example.jazelixirsclient.contract.IngredientDto;
import com.example.jazelixirsclient.elixirsclient.IElixirsClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JazElixirsClientApplication implements CommandLineRunner {

    IElixirsClient client;

    public JazElixirsClientApplication(IElixirsClient client) {
        this.client = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(JazElixirsClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        List<ElixirDto> list = Arrays.asList(client.getAllElixirs());
//
//
//        List<IngredientDto> ingredients = new ArrayList<>();
//
//        for (ElixirDto dto : list) {
//            System.out.println(dto.getName());
//        }

    }
}
