package com.example.entrevueSpringBoot.services.impl;

import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.mapper.FilmMapper;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import com.example.entrevueSpringBoot.services.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class Film Service.
 */
@Service
public class FilmServiceImpl implements FilmService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository, FilmMapper filmMapper) {
        this.filmRepository = filmRepository;
        this.filmMapper = filmMapper;
    }

    @Override
    public FilmDto create(FilmDto film) {
        return filmMapper.mapToDto(filmRepository.save(filmMapper.mapToEntity(film)));
    }

    @Override
    public Optional<FilmDto> GetFilm(long id) {
        return filmRepository.findById(id).map(filmMapper::mapToDto);
    }
}
