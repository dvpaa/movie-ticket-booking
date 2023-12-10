package jbnu.ssad1.repository.review;

import jbnu.ssad1.medel.entity.Review;

import java.util.List;

public interface ReviewRepository {

    Review save(Review review);

    Review findById(Long reviewId);

    List<Review> findAll();

    List<Review> findByMovieId(Long movieId);

    void clear();
}
