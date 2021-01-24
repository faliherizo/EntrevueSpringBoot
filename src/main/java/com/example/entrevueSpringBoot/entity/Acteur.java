package com.example.entrevueSpringBoot.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Faliherizo.
 */
@Entity
@Table(name = "ACTEUR")
public class Acteur {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id")
    private List<Film> films;
    
    public List<Film> getFilms() {
        if (films.isEmpty()) {
            films = Collections.emptyList();
        }
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acteur that = (Acteur) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
