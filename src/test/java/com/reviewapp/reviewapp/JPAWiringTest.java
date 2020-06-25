package com.reviewapp.reviewapp;


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
    public  void categoryShouldHaveAReview(){
        Category testCategory = new Category("Tech");
        Review testReview1 = new Review("title","description", testCategory, "synopsis", "imageurl");
        categoryRepo.save(testCategory);
        reviewRepo.save(testReview1);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOpt.get();
        //Review retrievedReview = reviewRepo.findById(testReview1.getId()).get();
        assertThat(retrievedCategory.getReviews()).contains(testReview1);


    }

    @Test
    public  void categoryShouldHaveMorThanOneReview(){
        Category testCategory = new Category("Tech");
        Review testReview1 = new Review("title","description", testCategory, "synopsis", "imageurl");
        Review testReview2 = new Review("dell","description", testCategory, "synopsis", "imageurl");
        categoryRepo.save(testCategory);
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOpt.get();
        //Review retrievedReview1 = reviewRepo.findById(testReview1.getId()).get();
        //Review retrievedReview2 = reviewRepo.findById(testReview2.getId()).get();
        assertThat(retrievedCategory.getReviews()).contains(testReview1, testReview2);

    }

    @Test
    public void twoCategoriesShouldHaveAtLeastOneReview(){
        Category testCategory1 = new Category("Tech");
        Category testCategory2 = new Category("Movies");
        Review testReview1 = new Review("title","description", testCategory1, "synopsis", "imageurl");
        Review testReview2 = new Review("avengers","description", testCategory2, "synopsis", "imageurl");
        categoryRepo.save(testCategory1);
        categoryRepo.save(testCategory2);
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt1 = categoryRepo.findById(testCategory1.getId());
        Optional<Category> retrievedCategoryOpt2 = categoryRepo.findById(testCategory2.getId());
        Category retrievedCategory1 = retrievedCategoryOpt1.get();
        Category retrievedCategory2 = retrievedCategoryOpt2.get();
        //Review retrievedReview1 = reviewRepo.findById(testReview1.getId()).get();
        //Review retrievedReview2 = reviewRepo.findById(testReview2.getId()).get();
        assertThat(retrievedCategory1.getReviews()).contains(testReview1);
        assertThat(retrievedCategory2.getReviews()).contains(testReview2);

    }

    @Test
    public void twoCategoriesShouldHaveMoreThanOneReview(){
        Category testCategory1 = new Category("Tech");
        Category testCategory2 = new Category("Movies");
        Review testReview1 = new Review("dell","description", testCategory1, "synopsis", "imageurl");
        Review testReview2 = new Review("Samsung","description", testCategory1, "synopsis", "imageurl");
        Review testReview3 = new Review("Avengers","description", testCategory2, "synopsis", "imageurl");
        Review testReview4 = new Review("The Matrix","description", testCategory2, "synopsis", "imageurl");
        categoryRepo.save(testCategory1);
        categoryRepo.save(testCategory2);
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);
        reviewRepo.save(testReview3);
        reviewRepo.save(testReview4);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt1 = categoryRepo.findById(testCategory1.getId());
        Optional<Category> retrievedCategoryOpt2 = categoryRepo.findById(testCategory2.getId());
        Category retrievedCategory1 = retrievedCategoryOpt1.get();
        Category retrievedCategory2 = retrievedCategoryOpt2.get();
        //Review retrievedReview1 = reviewRepo.findById(testReview1.getId()).get();
        //Review retrievedReview2 = reviewRepo.findById(testReview2.getId()).get();
        assertThat(retrievedCategory1.getReviews()).contains(testReview1, testReview2);
        assertThat(retrievedCategory2.getReviews()).contains(testReview3, testReview4);

    }








    }


