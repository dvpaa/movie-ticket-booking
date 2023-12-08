package jbnu.ssad1.service.movie;

import jbnu.ssad1.medel.entity.Movie;
import jbnu.ssad1.repository.movie.MovieRepository;

import java.time.LocalDate;
import java.util.List;

public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findMovieById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public List<Movie> findAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findScreeningMovies() {
        return movieRepository.findByScreening(true);
    }

    @Override
    public List<Movie> findScreeningSoonMovies() {
        return movieRepository.findNotReleasedMovies(LocalDate.now());
    }
}
