package jbnu.ssad1.medel.entity;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private Long id;
    private String title;
    private String director;
    private List<String> actors;
    private LocalDate releasedDate;
    private Double score;
    private Boolean screening;

    public Movie(String title, String director, List<String> actors, LocalDate releasedDate, Double score, Boolean screening) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.releasedDate = releasedDate;
        this.score = score;
        this.screening = screening;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Boolean isScreening() {
        return screening;
    }

    public void setScreening(Boolean screening) {
        this.screening = screening;
    }
}
