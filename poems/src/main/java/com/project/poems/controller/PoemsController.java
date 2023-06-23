package com.project.poems.controller;

import com.project.poems.api.PoemsService;
import com.project.poems.dto.AllAuthorsDTO;
import com.project.poems.dto.AuthorStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Random;

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
       Random rand = new Random();
       AllAuthorsDTO authors = poemsService.getAllAuthors();
       List<AuthorStats> authorsList = authors.getAuthors().stream()
               .filter(author -> !author.startsWith("B") && !author.startsWith("C"))
               .map(author -> new AuthorStats(author, rand.nextInt(101)))
               .toList();
       StringBuilder result = new StringBuilder();
       result.append("Авторы: </br> ");
       result.append("<ol>");
       for (AuthorStats point : authorsList) {
           result.append("<li>");
           result.append(point.getAuthors());
           result.append(" - ");
           result.append(point.getStats());
           result.append("</li>");
       }
       result.append("</ol>");
       return result.toString();
   }
}
