package com.project.reviews.controllers;


import com.project.reviews.repositories.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;



    @Controller
    public class ReviewController {

        @Resource
        private ReviewRepository reviewRepo;

        @RequestMapping("/reviews")
        public String displayReviews(Model model){
            model.addAttribute("reviews", reviewRepo.findAll());
            return "reviewsView";
        }
}
