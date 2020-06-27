package com.reviewapp.reviewapp;

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
        categoryRepo.save(technology);
        Category restaurant  = new Category("Restaurants");
        categoryRepo.save(restaurant);
        Category movies = new Category("Movies");
        categoryRepo.save(movies);
        Category vacation = new Category("Vacation Spots");
        categoryRepo.save(vacation);

        Review dellLaptop = new Review("Dell Laptop","Computer",technology,"lightweight powerhouse","/images/dell.jpg");
        Review macLaptop = new Review("Macbook Pro Laptop","Computer",technology,"design powerhouse","/images/mac.jpg");
        Review lenovoLaptop = new Review("Lenovo Laptop","Computer",technology,"Windows best laptop","/images/lenovo.jpg");

        Review mexicanFood = new Review("Best Mexican Food","El Vaquero",restaurant,"authentic cuisine",
                "/images/mexican.jpg");
        Review italianFood = new Review("Best Italian Food","Brio",restaurant,"authentic cuisine","/images/italian.jpg");
        Review americanFood = new Review("Best American Food","Thurman's Cafe",restaurant,"authentic cuisine","/images/american.jpg");

        Review avengers = new Review("Avengers Endgame","Best team superhero movie",movies,"Avengers vs Thanos","/images/avengers.jpg");
        Review spiderman = new Review("Spiderman 3","Best Spiderman movie",movies,"I forget what this one is about","/images/spiderman.jpg");

        Review maui = new Review("Maui: Best beaches","Maui's paradise",vacation,"best beaches in world","/images/maui.jpg");
        Review egypt = new Review("Egypt: Best sight seeing","Pyramids",vacation,"ancient architecture","/images/egypt.jpg");

        reviewRepo.save(dellLaptop);
        reviewRepo.save(macLaptop);
        reviewRepo.save(lenovoLaptop);
        reviewRepo.save(mexicanFood);
        reviewRepo.save(italianFood);
        reviewRepo.save(americanFood);
        reviewRepo.save(avengers);
        reviewRepo.save(spiderman);
        reviewRepo.save(maui);
        reviewRepo.save(egypt);




    }
}
