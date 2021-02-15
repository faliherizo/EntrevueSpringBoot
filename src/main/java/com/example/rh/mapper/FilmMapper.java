package com.example.rh.mapper;

import com.example.rh.dto.FilmDto;
import com.example.rh.entity.Film;
import com.example.rh.services.impl.FilmServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = FilmServiceImpl.class,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface FilmMapper {
    FilmDto mapToDto(Film film);

    Film mapToEntity(FilmDto film);
}
