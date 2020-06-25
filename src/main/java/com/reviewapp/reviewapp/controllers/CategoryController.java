package com.reviewapp.reviewapp.controllers;


import com.reviewapp.reviewapp.Category;
import com.reviewapp.reviewapp.CategoryRepository;
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
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryRepo.findAll());
        return "categoriesView";
    }

    @GetMapping("/categories/{type}")
    public String displaySingleCategory(@PathVariable String type, Model model){
        Category retrievedCategory = categoryRepo.findCategoryByType(type);
        model.addAttribute("category", retrievedCategory);
        return "categoryView";
    }


}
