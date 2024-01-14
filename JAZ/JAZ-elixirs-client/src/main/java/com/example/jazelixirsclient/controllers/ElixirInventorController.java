package com.example.jazelixirsclient.controllers;

import com.example.jazelixirsclient.services.ElixirInventorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/inventors")
@RequiredArgsConstructor
public class ElixirInventorController {
    private final ElixirInventorService elixirInventorService;
}
