package com.example.jazelixirsupdater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = {"com.example.jazdata", "com.example.jazelixirsclient", "com.example"})
public class JazElixirsUpdaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JazElixirsUpdaterApplication.class, args);
    }

}
