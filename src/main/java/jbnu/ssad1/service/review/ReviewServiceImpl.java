package jbnu.ssad1.service.review;

import jbnu.ssad1.medel.entity.Review;
import jbnu.ssad1.repository.review.ReviewRepository;

import java.util.List;

public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void writeReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review findReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findReviewByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }
}
