package com.project.platform.base.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpRequester {
    private final Logger logger = LoggerFactory.getLogger(HttpRequester.class);
    private final RestTemplate restTemplate;

    @Autowired
    public HttpRequester(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> get(String url, String parameters) {
        HttpEntity<Object> request = new HttpEntity<>(){};
        logger.info("Requesting external URL {} with request payload {}", url, null);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                parameters
        );
    }
}
