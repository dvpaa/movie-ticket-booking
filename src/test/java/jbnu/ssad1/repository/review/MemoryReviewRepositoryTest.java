package jbnu.ssad1.repository.review;

import jbnu.ssad1.medel.entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryReviewRepositoryTest {

    ReviewRepository reviewRepository = new MemoryReviewRepository();
    Movie movie1;
    Movie movie2;
    Screening screening1;
    Screening screening2;
    Booking booking1;

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

        this.screening1 = new Screening(movie1, LocalDateTime.of(2024, 12, 9, 13, 0));
        this.screening2 = new Screening(movie2, LocalDateTime.of(2024, 12, 13, 14, 0));
    }

    @AfterEach
    void tearDown() {
        reviewRepository.clear();
    }

    @Test
    void save() {
        Member member = new Member("email", "password", "name");
        member.setId(1L);

        Review review = new Review(booking1, "review");

        Review saved = reviewRepository.save(review);

        Review byId = reviewRepository.findById(review.getId());

        assertThat(saved).isEqualTo(byId);
    }

    @Test
    void findAll() {
        Member member1 = new Member("email1", "password1", "name1");
        member1.setId(1L);

        Member member2 = new Member("email2", "password2", "name2");
        member2.setId(2L);

        Booking booking1 = new Booking(member1, screening1);
        booking1.setId(1L);

        Booking booking2 = new Booking(member2, screening2);
        booking2.setId(2L);

        Review review1 = new Review(booking1, "review1");
        reviewRepository.save(review1);

        Review review2 = new Review(booking2, "review2");
        reviewRepository.save(review2);

        List<Review> all = reviewRepository .findAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(review1, review2);
    }

    @Test
    void findByMovieId() {
        Member member1 = new Member("email1", "password1", "name1");
        member1.setId(1L);

        Member member2 = new Member("email2", "password2", "name2");
        member2.setId(2L);

        Booking booking1 = new Booking(member1, screening1);
        booking1.setId(1L);

        Booking booking2 = new Booking(member2, screening1);
        booking2.setId(2L);

        Review review1 = new Review(booking1, "review1");
        reviewRepository.save(review1);

        Review review2 = new Review(booking2, "review2");
        reviewRepository.save(review2);

        List<Review> byMovieId = reviewRepository.findByMovieId(movie1.getId());

        assertThat(byMovieId.size()).isEqualTo(2);
        assertThat(byMovieId).contains(review1, review2);
    }
}