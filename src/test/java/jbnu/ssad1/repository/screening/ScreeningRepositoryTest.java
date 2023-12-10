package jbnu.ssad1.repository.screening;

import jbnu.ssad1.medel.entity.Movie;
import jbnu.ssad1.medel.entity.Screening;
import jbnu.ssad1.repository.movie.MemoryMovieRepository;
import jbnu.ssad1.repository.movie.MovieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScreeningRepositoryTest {

    ScreeningRepository screeningRepository = new MemoryScreeningRepository();
    MovieRepository movieRepository = new MemoryMovieRepository();
    Movie movie1;
    Movie movie2;

    @BeforeEach
    void setUp() {
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

        movieRepository.save(movie1);
        movieRepository.save(movie2);
    }

    @AfterEach
    void tearDown() {
        this.screeningRepository.clear();
        this.movieRepository.clear();
    }

    @Test
    void save() {
        Movie m = movieRepository.findById(1L);
        Screening screening = new Screening(m, LocalDateTime.of(2024, 12, 9, 16, 0));

        Screening saved = screeningRepository.save(screening);
        Screening byId = screeningRepository.findById(saved.getId());

        assertThat(saved).isEqualTo(byId);
    }

    @Test
    void findAll() {
        Screening screening1 = new Screening(movie1, LocalDateTime.of(2024, 12, 9, 13, 0));
        Screening screening2 = new Screening(movie2, LocalDateTime.of(2024, 12, 13, 14, 0));

        screeningRepository.save(screening1);
        screeningRepository.save(screening2);

        List<Screening> all = screeningRepository.findAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(screening1, screening2);
    }

    @Test
    void findNotStarted() {
        Screening screening1 = new Screening(movie1, LocalDateTime.of(2024, 12, 9, 13, 0));
        Screening screening2 = new Screening(movie2, LocalDateTime.of(2024, 12, 13, 14, 0));

        screeningRepository.save(screening1);
        screeningRepository.save(screening2);

        List<Screening> notStarted = screeningRepository.findNotStarted(LocalDateTime.of(2024, 12, 9, 16, 0));

        assertThat(notStarted.size()).isEqualTo(1);
        assertThat(notStarted).contains(screening2);

    }
}