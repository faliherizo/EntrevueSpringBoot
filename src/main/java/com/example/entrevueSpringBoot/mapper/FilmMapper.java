package com.example.entrevueSpringBoot.mapper;

import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.services.impl.FilmServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = FilmServiceImpl.class,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface FilmMapper {
    FilmDto mapToDto(Film film);

    Film mapToEntity(FilmDto film);
}
