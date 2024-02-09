package com.mycompany.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class RController {

    private static final Logger logger = LoggerFactory.getLogger(RController.class);

    @Autowired
    private RestClient restClient;

    @GetMapping("/")
    String getResult() {

        logger.info("Interacting with R Server");

        ResponseEntity<List<String>> result = this.restClient
                .get()
                .uri("http://localhost:3000/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {
                });
        return result.getBody().get(0);
    }
}