package jbnu.ssad1.service.review;

import jbnu.ssad1.medel.entity.Review;

import java.util.List;

public interface ReviewService {

    void writeReview(Review review);

    Review findReviewById(Long reviewId);

    List<Review> findAllReviews();

    List<Review> findReviewByMovieId(Long movieId);
}
