package com.example.rh.controllers;

import com.example.rh.controllers.exceptions.FilmNotFoundException;
import com.example.rh.dto.FilmDto;
import com.example.rh.services.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "/api")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film/{id}")
    @ApiOperation(httpMethod = "GET", tags = "Film", value = "Retourne une film par l'id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Un film est retourné correspondant à l'id"),
            @ApiResponse(code = 400, message = "Requête non valide"),
            @ApiResponse(code = 404, message = "Le film n'est pas trouvé."),
            @ApiResponse(code = 500, message = "Une erreur fonctionnelle a été retournée.")})
    public ResponseEntity<FilmDto> get(@PathVariable Long id) throws FilmNotFoundException {
        Optional<FilmDto> film = this.filmService.GetFilm(id);
        if(film.isPresent()){
            return new ResponseEntity<>(film.get(), HttpStatus.OK);
        }
        throw new FilmNotFoundException(id);
    }

    @ApiOperation(value = "Creation d un film")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Film créé"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping("/film")
    public ResponseEntity<FilmDto> post(@RequestBody FilmDto film) {
        return new ResponseEntity<>(this.filmService.create(film), HttpStatus.CREATED);
    }
}
