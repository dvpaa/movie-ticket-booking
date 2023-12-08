package jbnu.ssad1.repository.movie;

import jbnu.ssad1.medel.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository {
    Movie save(Movie movie);

    Movie findById(Long movieId);

    List<Movie> findAll();

    List<Movie> findByScreening(Boolean screening);

    List<Movie> findNotReleasedMovies(LocalDate releasedDate);

    void clear();
}
