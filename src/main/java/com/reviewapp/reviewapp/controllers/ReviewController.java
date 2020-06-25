package com.reviewapp.reviewapp.controllers;


import com.reviewapp.reviewapp.Category;
import com.reviewapp.reviewapp.Review;
import com.reviewapp.reviewapp.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class ReviewController {

    @Resource
    private ReviewRepository reviewRepo;

    @RequestMapping("/reviews")
    public String displayReviews(Model model){
        model.addAttribute("reviews", reviewRepo.findAll());
        return "reviewsView";
    }

    @RequestMapping("/reviews/{id}")
    public String displaySingleReview(@PathVariable Long id, Model model){
        Optional<Review> retrievedReview = reviewRepo.findById(id);
        Review foundReview = retrievedReview.get();
        model.addAttribute("review", foundReview);
        return "reviewView";
    }


}
