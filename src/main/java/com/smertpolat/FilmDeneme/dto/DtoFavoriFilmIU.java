package com.smertpolat.FilmDeneme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoFavoriFilmIU {

    private Long hariciFilmId;
    private String filmAdi;
    private String yayinTarihi;
    private Double puan;
    private String not;
    private boolean izlendiMi;

}
