package com.example.entrevueSpringBoot.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Faliherizo.
 */
@Entity
@Table(name = "FILM")
public class Film {
    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private String description;
    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id")
    private List<Acteur> acteurs;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Acteur> getActeurs() {
        if (acteurs == null) {
            acteurs = Collections.emptyList();
        }
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film that = (Film) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
