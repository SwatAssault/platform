package com.project.poems.bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.project.platform.base.http.HttpRequester;
import com.project.platform.base.http.Payload;
import com.project.platform.base.json.JsonMarshaller;
import com.project.poems.api.PoemsService;
import com.project.poems.dto.AllAuthorsDTO;
import com.project.poems.utils.PoemsUrls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PoemsServiceImpl implements PoemsService {
    private final Logger logger = LoggerFactory.getLogger(PoemsServiceImpl.class);

    private final HttpRequester httpRequester;

    @Autowired
    public PoemsServiceImpl(HttpRequester httpRequester) {
        this.httpRequester = httpRequester;
    }

    @Override
    public AllAuthorsDTO getAllAuthors() {
        Payload<AllAuthorsDTO> payload = processResponse(
                httpRequester.get(
                        PoemsUrls.Endpoint.AUTHORS.getUrl(),
                        null
                ),
                (response) -> JsonMarshaller.unmarshall(response, new TypeReference<>() {})
        );

        if (payload.getResponseObject() == null) {
            throw new RuntimeException("Error ");
        }

        return payload.getResponseObject();
    }

    // TODO добавить нормальную обработку ошибок
    private <T> Payload<T> processResponse(ResponseEntity<String> response, Function<String, T> block) {
        Payload<T> payload;

        if (HttpStatus.OK == response.getStatusCode()) {
            payload = new Payload<>(block.apply(response.getBody()));
        } else if (HttpStatus.UNAUTHORIZED == response.getStatusCode()) {
            throw new RuntimeException("UNAUTHORIZED");
        } else if (HttpStatus.NOT_FOUND == response.getStatusCode()) {
            throw new RuntimeException("NOT_FOUND");
        } else {
            payload = new Payload<>(
                    response.getBody(),
                    response.getStatusCode().value()
            );
            logger.error("Unknown error calling URL. Code: {}, Response: {}", response.getStatusCode(), response.getBody());
        }
        return payload;
    }
}
