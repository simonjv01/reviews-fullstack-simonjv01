package com.reviewapp.reviewapp;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Review findReviewByTitle(String title);
}
