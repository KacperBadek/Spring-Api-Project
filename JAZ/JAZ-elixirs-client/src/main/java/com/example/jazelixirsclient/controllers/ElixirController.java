package com.example.jazelixirsclient.controllers;

import com.example.jazelixirsclient.services.ElixirService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/elixirs")
@RequiredArgsConstructor
public class ElixirController {
    private final ElixirService elixirService;
}
