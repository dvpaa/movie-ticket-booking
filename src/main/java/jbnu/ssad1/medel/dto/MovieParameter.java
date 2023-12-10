package jbnu.ssad1.medel.dto;

import java.time.LocalDate;
import java.util.List;

public class MovieParameter {
    private final String title;
    private final String director;
    private final List<String> actors;
    private final LocalDate releasedDate;
    private final Double score;
    private final Boolean screening;

    public MovieParameter(String title, String director, List<String> actors, LocalDate releasedDate, Double score, Boolean screening) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.releasedDate = releasedDate;
        this.score = score;
        this.screening = screening;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActors() {
        return actors;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public Double getScore() {
        return score;
    }

    public Boolean isScreening() {
        return screening;
    }
}
