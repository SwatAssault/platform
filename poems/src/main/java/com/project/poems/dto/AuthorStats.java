package com.project.poems.dto;


public class AuthorStats {
    private String author;
    private int poemsNumber;

    public AuthorStats(String author, int poemsNumber) {
        this.author = author;
        this.poemsNumber = poemsNumber;
    }

    public String getAuthors() {
        return author;
    }

    public int getPoemsNumber() {
        return poemsNumber;
    }

    public void setAuthors(String authors) {
        this.author = authors;
    }

    public void setPoemsNumber(int stats) {
        this.poemsNumber = stats;
    }
}
