package com.smertpolat.FilmDeneme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DtoFavoriFilm {

    private Long id;
    private Long hariciFilmId;
    private String filmAdi;
    private String yayinTarihi;
    private Double puan;
    private String not;
    private boolean izlendiMi;

}
