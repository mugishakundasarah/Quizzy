package com.quizzyapp.service;

import com.quizzyapp.dto.UpdateCategoryDto;
import com.quizzyapp.model.Category;
import com.quizzyapp.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepositoryMock;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void getAll_withSomeElements(){
        when(categoryRepositoryMock.findAll()).thenReturn(Arrays.asList(new Category(1,"Maths"),new Category(2,"Physics")));
        assertEquals("Maths", categoryService.getAll().get(0).getValue());
        assertEquals("Physics", categoryService.getAll().get(1).getValue());
    }

    @Test
    public void update_success(){
        UpdateCategoryDto dto = new UpdateCategoryDto("Mathematics");
        Category category = new Category(1, "Mathcs");
        when(categoryRepositoryMock.findById(1)).thenReturn(Optional.of(category));
        when(categoryRepositoryMock.existsByName((dto.getName()))).thenReturn(true);;
        when(categoryRepositoryMock.save(category)).thenReturn(category);

        ResponseEntity<?> updateCategory = categoryService.updateCategory(1, dto);
        assertTrue(updateCategory.getStatusCode().is2xxSuccessful());
    }
}
