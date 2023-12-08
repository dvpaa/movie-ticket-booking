package jbnu.ssad1.service.movie;

import jbnu.ssad1.medel.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie findMovieById(Long movieId);

    List<Movie> findAllMovie();

    List<Movie> findScreeningMovies();

    List<Movie> findScreeningSoonMovies();
}
