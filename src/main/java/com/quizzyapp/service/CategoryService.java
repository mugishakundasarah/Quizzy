package com.quizzyapp.service;

import com.quizzyapp.dto.UpdateCategoryDto;
import com.quizzyapp.model.Category;
import com.quizzyapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public ResponseEntity<?> updateCategory(int id, UpdateCategoryDto dto){
        Optional<Category> findById = categoryRepository.findById(id);
        if(findById.isPresent()){
            Category category = findById.get();

            if (categoryRepository.existsByName(category.getValue()) && category.getValue().equalsIgnoreCase(dto.getName())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("category already exists!");
            };

            category.setName(dto.getName());
            categoryRepository.save(category);

            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("category does not exist");
    }

}
