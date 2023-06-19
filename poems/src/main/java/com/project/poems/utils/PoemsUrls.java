package com.project.poems.utils;

public final class PoemsUrls {

    private static final String POETRY_DB_URL = "https://poetrydb.org";

    public enum Endpoint {
        AUTHORS("/authors");

        private final String url;

        Endpoint(String url) {
            this.url = url;
        }

        public String getUrl() {
            return POETRY_DB_URL + url;
        }
    }
}
