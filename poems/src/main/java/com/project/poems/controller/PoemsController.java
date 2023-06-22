package com.project.poems.controller;

import com.project.poems.api.PoemsService;
import com.project.poems.dto.AllAuthorsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Stream;
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
       Stream stream = authors.getAuthors().stream();
       stream = stream
               .filter(x -> (x.toString().charAt(0) != 'B' & x.toString().charAt(0) != 'C'))
               .map(x -> "<li>" + x.toString()+ " - " + rand.nextInt(101) + "</li>");
       StringBuilder result = new StringBuilder();
       if (authors != null) {
           result.append("Авторы: <ol>");
           result.append(String.join("",stream.toList()));
           result.append("</ol>");
       }
       return result.toString();
    }
}
