package jbnu.ssad1.repository.review;

import jbnu.ssad1.medel.entity.Review;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryReviewRepository implements ReviewRepository{

    private static Map<Long, Review> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Review save(Review review) {
        review.setId(++sequence);
        store.put(review.getId(), review);
        return review;
    }

    @Override
    public Review findById(Long reviewId) {
        return store.get(reviewId);
    }

    @Override
    public List<Review> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Review> findByMovieId(Long movieId) {
        return findAll().stream()
                .filter(review -> Objects.equals(review.getBooking().getScreening().getMovie().getId(), movieId))
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
