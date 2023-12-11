package jbnu.ssad1.repository.movie;

import jbnu.ssad1.medel.entity.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryMovieRepository implements MovieRepository {

    private static Map<Long, Movie> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Movie save(Movie movie) {
        movie.setId(++sequence);
        store.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public Movie findById(Long movieId) {
        return store.get(movieId);
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Movie> findByScreening(Boolean screening) {
        return store.values()
                .stream()
                .filter(Movie::isScreening)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> findNotReleasedMovies(LocalDate date) {
        return store.values()
                .stream()
                .filter(movie -> date.isBefore(movie.getReleasedDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return findAll()
                .stream()
                .filter(movie -> movie.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
