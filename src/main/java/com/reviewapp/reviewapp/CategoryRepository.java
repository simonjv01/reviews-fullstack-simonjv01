package com.reviewapp.reviewapp;


import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryByType(String type);
}
