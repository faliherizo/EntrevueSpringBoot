package com.example.entrevueSpringBoot.controllers.exceptions;

/**
 * Class FilmNotFoundException.
 */
public class FilmNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String FILM_NON_TROUVE = "Film non trouvé: ";

    public FilmNotFoundException(Long id) {
        super(FILM_NON_TROUVE + id);
    }
}
