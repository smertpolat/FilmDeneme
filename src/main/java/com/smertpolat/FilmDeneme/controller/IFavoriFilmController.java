package com.smertpolat.FilmDeneme.controller;

import com.smertpolat.FilmDeneme.dto.DtoFavoriFilm;
import com.smertpolat.FilmDeneme.dto.DtoFavoriFilmIU;
import com.smertpolat.FilmDeneme.dto.DtoTmdbAramaCevabi;
import java.util.List;

public interface IFavoriFilmController {

    DtoFavoriFilm saveFavoriFilm (DtoFavoriFilmIU dtoFavoriFilmIU);

    DtoFavoriFilm findById(Long id);

    List<DtoFavoriFilm> listAll();

    DtoFavoriFilm update(Long id, DtoFavoriFilmIU dtoFavoriFilmIU);

    void delete(Long id);

    DtoTmdbAramaCevabi filmAra(String filmAdi);


}
