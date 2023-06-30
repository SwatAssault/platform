package com.project.poems.controller;

import com.project.poems.api.PoemsService;
import com.project.poems.dto.AllAuthorsDTO;
import com.project.poems.dto.AuthorStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/poems")
public class PoemsController {

    private final PoemsService poemsService;

    @Autowired
    public PoemsController(PoemsService poemsService) {
        this.poemsService = poemsService;
    }

    @GetMapping("/authors")
    public String getAllAuthors() {
        StringBuilder result = new StringBuilder();
        AllAuthorsDTO authors = poemsService.getAllAuthors();
        if (authors != null) {
            result.append("Авторы: </br>");
            result.append(String.join(", </br>", authors.getAuthors()));
        }
        return result.toString();
    }

    @GetMapping("/authors-and-poems")
    public String getAuthorsAndPoems() {
        List<AuthorStats> statistics = poemsService.getStatistics();
        StringBuilder result = new StringBuilder();
        result.append("Авторы: </br> ");
        result.append("<ol>");
        for (AuthorStats author : statistics) {
            result.append("<li>");
            result.append(author.getAuthors());
            result.append(" - ");
            result.append(author.getPoemsNumber());
            result.append("</li>");
        }
        result.append("</ol>");
        return result.toString();
    }

    @GetMapping("/titles/{authorName}")
    public String getAuthorTitles(@PathVariable String authorName) {
        StringBuilder result = new StringBuilder();
        List<String> allAuthorTitles = poemsService.getAuthorTitles(authorName);
        result.append(authorName).append(": </br>");
        for (String title : allAuthorTitles) {
            result.append("-\"").append(title).append("\"").append(", </br>");
        }
        return result.toString();
    }
}
