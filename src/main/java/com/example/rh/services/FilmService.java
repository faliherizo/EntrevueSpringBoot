package com.example.rh.services;

import com.example.rh.dto.FilmDto;

import java.util.Optional;

/**
 * Class Film Service.
 */
public interface FilmService {
    /**
     * Methode pour créer un film.
     *
     * @param film FilmDto.
     * @return FilmDto
     */
    FilmDto create(FilmDto film);

    /**
     * Methode pour recuperer un Film.
     *
     * @param id de type long.
     * @return FilmDto.
     */
    Optional<FilmDto> GetFilm(long id);
}
