package jbnu.ssad1.repository.booking;

import jbnu.ssad1.medel.entity.Booking;
import jbnu.ssad1.medel.entity.Member;
import jbnu.ssad1.medel.entity.Movie;
import jbnu.ssad1.medel.entity.Screening;
import jbnu.ssad1.repository.movie.MemoryMovieRepository;
import jbnu.ssad1.repository.movie.MovieRepository;
import jbnu.ssad1.repository.screening.MemoryScreeningRepository;
import jbnu.ssad1.repository.screening.ScreeningRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryBookingRepositoryTest {

    BookingRepository bookingRepository = new MemoryBookingRepository();
    ScreeningRepository screeningRepository = new MemoryScreeningRepository();
    MovieRepository movieRepository = new MemoryMovieRepository();
    Movie movie1;
    Movie movie2;
    Screening screening1;
    Screening screening2;

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

        this.screening1 = new Screening(movie1, LocalDateTime.of(2024, 12, 9, 13, 0));
        this.screening2 = new Screening(movie2, LocalDateTime.of(2024, 12, 13, 14, 0));

        screeningRepository.save(screening1);
        screeningRepository.save(screening2);
    }

    @AfterEach
    void tearDown() {
        movieRepository.clear();
        screeningRepository.clear();
        bookingRepository.clear();
    }

    @Test
    void save() {
        Member member = new Member("email", "password", "name");
        member.setId(1L);

        Booking booking = new Booking(member, screening1);

        Booking saved = bookingRepository.save(booking);

        Booking byId = bookingRepository.findById(booking.getId());

        assertThat(saved).isEqualTo(byId);
    }

    @Test
    void findAll() {
        Member member1 = new Member("email1", "password1", "name1");
        member1.setId(1L);

        Member member2 = new Member("email2", "password2", "name2");
        member2.setId(2L);

        Booking booking1 = new Booking(member1, screening1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(member2, screening2);
        bookingRepository.save(booking2);


        List<Booking> all = bookingRepository.findAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(booking1, booking2);
    }

    @Test
    void findByMemberId() {
        Member member1 = new Member("email1", "password1", "name1");
        member1.setId(1L);

        Member member2 = new Member("email2", "password2", "name2");
        member2.setId(2L);

        Booking booking1 = new Booking(member1, screening1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(member2, screening2);
        bookingRepository.save(booking2);

        List<Booking> byMemberId = bookingRepository.findByMemberId(member2.getId());

        assertThat(byMemberId.size()).isEqualTo(1);
        assertThat(byMemberId).contains(booking2);
    }
}