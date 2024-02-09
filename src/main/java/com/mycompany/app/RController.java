package com.mycompany.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class RController {

    @Autowired
    private RestClient restClient;

    @GetMapping("/")
    List<String> getResult() {

        ResponseEntity<List<String>> result = this.restClient
                .get()
                .uri("http://localhost:3000/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {
                });
        return result.getBody();
    }
}