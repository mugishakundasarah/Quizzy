package com.quizzyapp.controller;

import com.quizzyapp.dto.UpdateCategoryDto;
import com.quizzyapp.model.Category;
import com.quizzyapp.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {
    @MockBean
    private CategoryService categoryServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAll_success() throws  Exception {
        List<Category> categories = Arrays.asList(new Category(1, "Mathematics"), new Category(2, "Politics"));
        when(categoryServiceMock.getAll()).thenReturn(categories);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/all-categories")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Mathematics\"},{\"id\":2,\"name\":\"Politics\"}]"))
                .andReturn();
    }

    @Test
    public void update_success() throws  Exception {
        Category category = new Category(1,"Maths");
        ResponseEntity.status(HttpStatus.CREATED).body(category);

        ResponseEntity<?> response = ResponseEntity.status(HttpStatus.CREATED).body(category);
        when(categoryServiceMock.updateCategory(1, new UpdateCategoryDto("Mathematics"))).thenReturn(null);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/all-categories/2")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isNotFound())
                //.andExpect(content().string(""))
                .andExpect(content().json("{\"status\":false,\"message\":\"Category not found\"}"))
                .andReturn();
        }
}
