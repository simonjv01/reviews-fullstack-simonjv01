package com.project.reviews.repositories;

import com.project.reviews.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {


    Category findCategoryByType(String type);
}
