package com.project.reviews;


import com.project.reviews.models.Category;
import com.project.reviews.models.Review;
import com.project.reviews.repositories.CategoryRepository;
import com.project.reviews.repositories.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Test
    public void categoryShouldHaveListOfReviews() {
        Category testCategory = new Category("Technology");
        Review reviewTech1 = new Review("Tech","dell.jpg",testCategory,"laptop review","travel laptop");

        reviewRepo.save(reviewTech1);
        categoryRepo.save(testCategory);


        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOpt.get();
        Review retrievedReview = reviewRepo.findById(reviewTech1.getId()).get();
        assertThat(retrievedCategory.getReviews()).contains(reviewTech1);

    }









}
