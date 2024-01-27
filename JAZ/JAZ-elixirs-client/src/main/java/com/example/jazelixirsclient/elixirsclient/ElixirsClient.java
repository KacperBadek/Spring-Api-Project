package com.example.jazelixirsclient.elixirsclient;

import com.example.jazelixirsclient.contract.ElixirDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ElixirsClient implements IElixirsClient {

    RestTemplate restClient;
    String baseUrl;
    private final IElixirsClientSettings settings;

    public ElixirsClient(IElixirsClientSettings settings) {
        restClient = new RestTemplate();
        this.settings = settings;
        this.baseUrl = settings.getBaseUrl();
    }

    @Override
    public ElixirDto[] getAllElixirs() {

        var url = settings.getUrlBuilder()
                .pathSegment("Elixirs")
                .build()
                .toUriString();

        return restClient.getForObject(url, ElixirDto[].class);
    }
}
