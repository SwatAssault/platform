package com.project.platform.base.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HttpRequester {
    private final Logger logger = LoggerFactory.getLogger(HttpRequester.class);
    private final RestTemplate restTemplate;

    @Autowired
    public HttpRequester(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> get(String url, Map<String, String> parameters) {
        logger.info("Requesting external URL {}", url);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class,
                parameters != null ? parameters : new HashMap<String, String>()
        );
    }
}
