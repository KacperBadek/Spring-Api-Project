package com.example.jazelixirsclient.elixirsclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ElixirsClientSettings implements IElixirsClientSettings {
    @Value("${wizardworld.api.host}")
    private String baseUrl;

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }


}
