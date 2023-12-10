package jbnu.ssad1.medel.entity;

import java.time.LocalDateTime;

public class Screening {
    private Long id;
    private Movie movie;
    private LocalDateTime screeningDate;

    public Screening(Movie movie, LocalDateTime screeningDate) {
        this.movie = movie;
        this.screeningDate = screeningDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(LocalDateTime screeningDate) {
        this.screeningDate = screeningDate;
    }
}
