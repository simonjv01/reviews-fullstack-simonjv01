package com.project.reviews;


import com.project.reviews.models.Category;
import com.project.reviews.models.Review;
import com.project.reviews.repositories.CategoryRepository;
import com.project.reviews.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private CategoryRepository categoryRepo;

    @Resource
    private ReviewRepository reviewRepo;

    @Override
    public void run(String... args) throws Exception {

        Category technology = new Category("Technology");
        Category movies = new Category("Movies");
        Category food = new Category("Food");
        categoryRepo.save(food);
        categoryRepo.save(movies);
        categoryRepo.save(technology);

        Review dellReview = new Review("Dell laptop","dell.jpg",technology,"windows laptop","good for travel");
        Review avengersReview = new Review("Avengers","avengers.jpg",movies,"sci-fi","action packed");
        Review primeSteakReview = new Review("Prime Steakhouse","steak.jpg",food,"steak house restaurant","Best steaks in Columbus");
        reviewRepo.save(dellReview);
        reviewRepo.save(avengersReview);
        reviewRepo.save(primeSteakReview);

    }
}
