package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.entity.Film;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Faliherizo.
 */
public interface FilmRepository extends CrudRepository<Film, Long> {

}
