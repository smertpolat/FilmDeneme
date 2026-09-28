package com.smertpolat.FilmDeneme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favori_film")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "harici_film_id")
    private Long hariciFilmId;

    @Column(name = "film_adi")
    private String filmAdi;

    @Column(name = "yayin_tarihi")
    private String yayinTarihi;

    @Column(name = "puan")
    private Double puan;

    @Column(name = "kullanici_notu")
    private String not;

    @Column(name = "izlendi_mi")
    private Boolean izlendiMi;

}
