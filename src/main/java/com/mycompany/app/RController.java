package com.mycompany.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
public class RController {

    private static final Logger logger = LoggerFactory.getLogger(RController.class);

    @Autowired
    private RestClient restClient;

    @GetMapping("/demo")
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

    @PostMapping("/sum")
    String receiveSum() {

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

    
    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage() {
        // URL of the PNG image
        String imageUrl = "http://localhost:3000/plot";

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Request the image data as InputStream
        ResponseEntity<byte[]> response = restTemplate.getForEntity(imageUrl, byte[].class);

        // Get the image data as byte array
        byte[] imageBytes = response.getBody();

        // Set the content type of the response
        MediaType mediaType = MediaType.IMAGE_PNG;

        // Return the image bytes with appropriate content type
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }

}