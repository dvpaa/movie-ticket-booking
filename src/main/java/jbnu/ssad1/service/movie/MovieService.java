package jbnu.ssad1.service.movie;

import jbnu.ssad1.medel.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findScreeningMovies();

    List<Movie> findUpcomingSoonMovies();

    List<Movie> findByMovieTitle(String title);
}
