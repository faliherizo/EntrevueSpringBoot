package com.example.rh.services.impl;

import com.example.rh.dto.FilmDto;
import com.example.rh.mapper.FilmMapper;
import com.example.rh.repository.FilmRepository;
import com.example.rh.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class Film Service.
 */
@Service
public class FilmServiceImpl implements FilmService {
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
