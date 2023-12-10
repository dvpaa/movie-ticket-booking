package jbnu.ssad1.repository.movie;

import jbnu.ssad1.medel.entity.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieRepositoryTest {

    MovieRepository movieRepository = new MemoryMovieRepository();
    Movie movie1;
    Movie movie2;

    @BeforeEach
    void setup() {
        this.movie1 = new Movie(
                "서울의 봄",
                "김성수",
                Arrays.asList("황정민", "정우성", "이성민", "박해준", "김성균", "김의성"),
                LocalDate.of(2023, 11, 22),
                9.57,
                true
        );

        this.movie2 = new Movie(
                "말하고 싶은 비밀",
                "타케무라 켄타로",
                Arrays.asList("타카하시 후미야", "사쿠라다 히요리"),
                LocalDate.of(2023, 12, 13),
                null,
                false
        );
    }

    @AfterEach
    void after() {
        movieRepository.clear();
    }


    @Test
    void save() {
        Movie saved1 = movieRepository.save(this.movie1);

        Movie findMovie = movieRepository.findById(this.movie1.getId());

        assertThat(saved1).isEqualTo(findMovie);
    }

    @Test
    void findALl() {
        movieRepository.save(this.movie1);
        movieRepository.save(this.movie2);

        List<Movie> movies = movieRepository.findAll();

        assertThat(movies.size()).isEqualTo(2);
        assertThat(movies).contains(this.movie1, this.movie2);
    }

    @Test
    void findScreeningMovies() {
        movieRepository.save(this.movie1);
        movieRepository.save(this.movie2);

        List<Movie> screening = movieRepository.findByScreening(true);

        assertThat(screening.size()).isEqualTo(1);
        assertThat(screening).contains(this.movie1);
    }

    @Test
    void findNotReleasedMovies() {
        movieRepository.save(this.movie1);
        movieRepository.save(this.movie2);

        List<Movie> byAfterDate = movieRepository.findNotReleasedMovies(LocalDate.of(2023, 12, 9));

        assertThat(byAfterDate.size()).isEqualTo(1);
        assertThat(byAfterDate).contains(this.movie2);
    }

    @Test
    void findByMovieTitle() {
        movieRepository.save(this.movie1);
        movieRepository.save(this.movie2);

        List<Movie> movies = movieRepository.findByTitle("서울");

        assertThat(movies.size()).isEqualTo(1);
        assertThat(movies).contains(movie1);
    }
}
