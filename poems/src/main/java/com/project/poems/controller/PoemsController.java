package com.project.poems.controller;

import com.project.poems.api.PoemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poems/")
public class PoemsController {

    private final PoemsService poemsService;

    @Autowired
    public PoemsController(PoemsService poemsService) {
        this.poemsService = poemsService;
    }

    @GetMapping("authors/")
    public String getAllAuthors() {
        return poemsService.getAllAuthors();
    }
}
