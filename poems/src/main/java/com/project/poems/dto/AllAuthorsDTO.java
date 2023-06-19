package com.project.poems.dto;

import java.util.List;

public class AllAuthorsDTO {

    private List<String> authors;

    public AllAuthorsDTO() {
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
