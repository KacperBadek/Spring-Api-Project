package com.example.jazelixirsclient.services;

import com.example.jazdata.repositories.ICatalogData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElixirService {
    private final ICatalogData db;

}
