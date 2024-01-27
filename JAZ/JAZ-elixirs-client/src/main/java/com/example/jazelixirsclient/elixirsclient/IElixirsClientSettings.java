package com.example.jazelixirsclient.elixirsclient;

import org.springframework.web.util.UriComponentsBuilder;

public interface IElixirsClientSettings {

    String getBaseUrl();

    default UriComponentsBuilder getUrlBuilder() {
        return UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(getBaseUrl());
    }

}
