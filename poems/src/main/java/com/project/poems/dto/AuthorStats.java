package com.project.poems.dto;


public class AuthorStats {
    private String authors;
    private int stats;

    public AuthorStats(String authors, int stats) {
        this.authors = authors;
        this.stats = stats;
    }

    public String getAuthors() {
        return authors;
    }

    public int getStats() {
        return stats;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }
}
