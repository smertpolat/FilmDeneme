package com.smertpolat.FilmDeneme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoTmdbFilm {

    private Long id;
    private String title;
    private String release_date;
    private Double vote_average;
    private String overview;

}
