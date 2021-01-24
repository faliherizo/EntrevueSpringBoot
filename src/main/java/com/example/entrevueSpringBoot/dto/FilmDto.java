package com.example.entrevueSpringBoot.dto;

import java.util.List;

/**
 * Entity FilmDto.
 */
public class FilmDto {
    private long id;
    private String titre;
    private String description;
    private List<ActeurDto> acteurs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ActeurDto> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<ActeurDto> acteurs) {
        this.acteurs = acteurs;
    }
}
