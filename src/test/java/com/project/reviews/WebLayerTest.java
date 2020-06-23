package com.project.reviews;


import com.project.reviews.models.Category;
import com.project.reviews.repositories.CategoryRepository;
import com.project.reviews.repositories.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @MockBean
    private CategoryRepository categoryRepo;

    @MockBean
    private ReviewRepository reviewRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void categoryShouldBeOkAndReturnCategoriesViewWithCategoryModelViewAttribute() throws Exception {
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesView"))
                .andExpect(model().attributeExists("categories"));
    }

    @Test
    public void reviewsShouldBeOkAndReturnReviewsViewWithReviewModelViewAttribute() throws Exception {
        mockMvc.perform(get("/reviews"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reviewsView"))
                .andExpect(model().attributeExists("reviews"));
    }

    @Test
    public void shouldBeOkForASingleCategoryEndpointWithCategoryViewAndCategoryModelAttribute() throws Exception{
        Category testCategory = new Category("Technology");
        when(categoryRepo.findCategoryByType("Technology")).thenReturn(testCategory);
        mockMvc.perform(get("/categories/Technology"))
                .andExpect(status().isOk())
                .andExpect(view().name("categoryView"))
                .andExpect(model().attributeExists("category"));
    }
}
