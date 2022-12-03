package com.quizzyapp.controller;

import com.quizzyapp.dto.UpdateCategoryDto;
import com.quizzyapp.model.Category;
import com.quizzyapp.repository.CategoryRepository;
import com.quizzyapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all-categories")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PutMapping("all-categories/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(name="id") int id, @Valid UpdateCategoryDto dto){
        return categoryService.updateCategory(id, dto);
    }
}
