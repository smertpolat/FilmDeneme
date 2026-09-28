package com.smertpolat.FilmDeneme.service.impl;

import com.smertpolat.FilmDeneme.client.FilmApiClient;
import com.smertpolat.FilmDeneme.dto.DtoFavoriFilm;
import com.smertpolat.FilmDeneme.dto.DtoFavoriFilmIU;
import com.smertpolat.FilmDeneme.dto.DtoTmdbAramaCevabi;
import com.smertpolat.FilmDeneme.entity.FavoriFilm;
import com.smertpolat.FilmDeneme.repository.FavoriFilmRepository;
import com.smertpolat.FilmDeneme.service.IFavoriFilmService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriFilmServiceImpl implements IFavoriFilmService {

    private final FavoriFilmRepository favoriFilmRepository;

    private final FilmApiClient filmApiClient;

    public FavoriFilmServiceImpl(FavoriFilmRepository favoriFilmRepository, FilmApiClient filmApiClient) {
        this.favoriFilmRepository = favoriFilmRepository;
        this.filmApiClient = filmApiClient;
    }

    @Override
    public DtoFavoriFilm saveFavoriFilm(DtoFavoriFilmIU dtoFavoriFilmIU) {

        FavoriFilm favoriFilm = new FavoriFilm();

        BeanUtils.copyProperties(dtoFavoriFilmIU, favoriFilm);

        FavoriFilm favoriFilm1 = favoriFilmRepository.save(favoriFilm);

        DtoFavoriFilm dtoFavoriFilm = new DtoFavoriFilm();

        BeanUtils.copyProperties(favoriFilm1, dtoFavoriFilm);

        return dtoFavoriFilm;
    }

    @Override
    public DtoFavoriFilm findById(Long id) {

        FavoriFilm favoriFilm = favoriFilmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favori film bulunamadı"));

        DtoFavoriFilm dtoFavoriFilm = new DtoFavoriFilm();

        BeanUtils.copyProperties(favoriFilm, dtoFavoriFilm);

        return dtoFavoriFilm;

    }

    @Override
    public List<DtoFavoriFilm> listAll() {

        List<FavoriFilm> favoriFilmler = favoriFilmRepository.findAll();

        List<DtoFavoriFilm> dtoFavoriFilmler = new ArrayList<>();

        for (FavoriFilm favoriFilm : favoriFilmler) {

            DtoFavoriFilm dtoFavoriFilm = new DtoFavoriFilm();

            BeanUtils.copyProperties(favoriFilm, dtoFavoriFilm);

            dtoFavoriFilmler.add(dtoFavoriFilm);
        }

        return dtoFavoriFilmler;

    }

    @Override
    public DtoFavoriFilm update(Long id, DtoFavoriFilmIU dtoFavoriFilmIU) {
        FavoriFilm favoriFilm = favoriFilmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favori film bulunamadı"));

        BeanUtils.copyProperties(dtoFavoriFilmIU, favoriFilm);

        FavoriFilm dbFavoriFilm = favoriFilmRepository.save(favoriFilm);

        DtoFavoriFilm dtoFavoriFilm = new DtoFavoriFilm();

        BeanUtils.copyProperties(dbFavoriFilm, dtoFavoriFilm);

        return dtoFavoriFilm;
    }

    @Override
    public void delete(Long id) {

        FavoriFilm favoriFilm = favoriFilmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favori film bulunamadı"));

        favoriFilmRepository.delete(favoriFilm);

    }

    @Override
    public DtoTmdbAramaCevabi filmAra(String filmAdi) {
        return filmApiClient.filmAra(filmAdi);
    }
}
