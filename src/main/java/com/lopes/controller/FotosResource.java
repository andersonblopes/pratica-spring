package com.lopes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fotos")
public class FotosResource {

    @GetMapping
    public String testeAplicacao() {
        return " Hello World!";
    }
}
