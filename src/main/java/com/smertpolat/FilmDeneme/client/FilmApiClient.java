package com.smertpolat.FilmDeneme.client;

import com.smertpolat.FilmDeneme.dto.DtoTmdbAramaCevabi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class FilmApiClient {

    private final RestClient restClient;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public FilmApiClient() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.themoviedb.org/3")
                .build();
    }

    public DtoTmdbAramaCevabi filmAra(String filmAdi) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/movie")
                        .queryParam("api_key", apiKey)
                        .queryParam("query", filmAdi)
                        .queryParam("language", "tr-TR")
                        .build())
                .retrieve()
                .body(DtoTmdbAramaCevabi.class);
    }
}