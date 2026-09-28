package com.smertpolat.FilmDeneme.controller.impl;

import com.smertpolat.FilmDeneme.controller.IFavoriFilmController;
import com.smertpolat.FilmDeneme.dto.DtoFavoriFilm;
import com.smertpolat.FilmDeneme.dto.DtoFavoriFilmIU;
import com.smertpolat.FilmDeneme.dto.DtoTmdbAramaCevabi;
import com.smertpolat.FilmDeneme.service.IFavoriFilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/favori-film")
public class FavoriFilmControllerImpl implements IFavoriFilmController {

    private final IFavoriFilmService favoriFilmService;

    public FavoriFilmControllerImpl(IFavoriFilmService favoriFilmService) {
        this.favoriFilmService = favoriFilmService;
    }

    @PostMapping("/save")
    @Override
    public DtoFavoriFilm saveFavoriFilm(@RequestBody DtoFavoriFilmIU dtoFavoriFilmIU) {
        return favoriFilmService.saveFavoriFilm(dtoFavoriFilmIU);
    }

    @GetMapping("/find-id/{id}")
    @Override
    public DtoFavoriFilm findById(@PathVariable Long id) {
        return favoriFilmService.findById(id);
    }

    @GetMapping("/list-all")
    @Override
    public List<DtoFavoriFilm> listAll() {
        return favoriFilmService.listAll();
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoFavoriFilm update(@PathVariable Long id,
                                @RequestBody DtoFavoriFilmIU dtoFavoriFilmIU) {
        return favoriFilmService.update(id, dtoFavoriFilmIU);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        favoriFilmService.delete(id);
    }

    @GetMapping("/ara")
    @Override
    public DtoTmdbAramaCevabi filmAra(@RequestParam String filmAdi) {
        return favoriFilmService.filmAra(filmAdi);
    }

}
