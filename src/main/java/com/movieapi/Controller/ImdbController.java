package com.movieapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImdbController {
    private RestTemplate restTemplate;

    @Autowired
    public ImdbController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/top100movies")
    public ResponseEntity<String> getTop100Movies() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "3fe421aa57mshdfd4147f4d4c319p1ba7f4jsnca7d59efce2d");
        headers.set("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange("https://imdb-top-100-movies.p.rapidapi.com/", HttpMethod.GET, entity, String.class);

        return response;
    }
}
