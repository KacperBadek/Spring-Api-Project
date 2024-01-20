package com.example.jazwebapi;

import com.example.jazdata.repositories.ICatalogData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = {"com.example.jazdata", "com.example"})

public class JazWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JazWebApiApplication.class, args);
    }

}
