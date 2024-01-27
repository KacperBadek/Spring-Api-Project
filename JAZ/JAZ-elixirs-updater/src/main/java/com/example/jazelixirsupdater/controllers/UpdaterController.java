package com.example.jazelixirsupdater.controllers;

import com.example.jazelixirsupdater.updater.IUpdateElixirs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("updater")
@RequiredArgsConstructor
public class UpdaterController {
    private final IUpdateElixirs updater;

    @PostMapping("start")
    public ResponseEntity start() {
        updater.updateAll();
        return ResponseEntity.ok("Update started on" + LocalDateTime.now());
    }


}
