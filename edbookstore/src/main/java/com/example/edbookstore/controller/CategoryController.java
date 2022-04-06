package com.example.edbookstore.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edbookstore.exception.ResourceNotFoundException;
import com.example.edbookstore.model.Category;
import com.example.edbookstore.model.Book;
import com.example.edbookstore.payload.CategoryResponse;
import com.example.edbookstore.repository.CategoryRepository;
import com.example.edbookstore.service.CategoryService;
import com.example.edbookstore.payload.CategoryRequest;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
   	public List<CategoryResponse> getAllBooks() {
        return categoryService.getAllCategories();
    }

	@PostMapping("/category")
	public CategoryRequest createCategory(@Valid @RequestBody CategoryRequest request) {
        return categoryService.createEditCategory(request);
    }
	

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        return categoryRepository.findById(categoryId).map(cat -> {
        	categoryRepository.delete(cat);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("categoryId " + categoryId + " not found", null, categoryId));
    }
}

