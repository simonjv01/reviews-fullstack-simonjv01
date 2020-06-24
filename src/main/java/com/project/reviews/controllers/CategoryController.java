package com.project.reviews.controllers;


import com.project.reviews.models.Category;
import com.project.reviews.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class CategoryController {

    @Resource
    private CategoryRepository categoryRepo;

    @RequestMapping({"/categories", "/", ""})
    public String displayCampuses(Model model){
        model.addAttribute("categories", categoryRepo.findAll());
        return "categoriesView";
    }

    @RequestMapping("/categories/{type}")
    public String displaysSingleCategory(@PathVariable String type, Model model){
        Category retrievedCategory = categoryRepo.findCategoryByType(type);
        model.addAttribute("category", retrievedCategory);
        return "categoryView";
    }

}
