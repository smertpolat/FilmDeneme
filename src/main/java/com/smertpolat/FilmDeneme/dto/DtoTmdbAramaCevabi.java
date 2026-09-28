package com.smertpolat.FilmDeneme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DtoTmdbAramaCevabi {

    private Integer page;

    private List<DtoTmdbFilm> results;

}
