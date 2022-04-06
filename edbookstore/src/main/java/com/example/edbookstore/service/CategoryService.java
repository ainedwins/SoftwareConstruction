package com.example.edbookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.edbookstore.model.Category;
import com.example.edbookstore.payload.CategoryRequest;
import com.example.edbookstore.payload.CategoryResponse;
import com.example.edbookstore.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
//	Creating or Editing a category
	public CategoryRequest createEditCategory(CategoryRequest categoryRequest) {
		
		Optional<Category> existingBook  = categoryRequest.getId() != null ? categoryRepository.findById(categoryRequest.getId()) :
			Optional.empty();
		
		
        
		Category cat = existingBook.isPresent() ? existingBook.get() :  new Category();
		
        cat.setName(categoryRequest.getName());
                
        return categoryRepository.save(cat) != null ? categoryRequest : null;
    }
	
	public List<CategoryResponse> getAllCategories() {
		List<CategoryResponse> cats = new ArrayList<>();
		
		for(Category cat : categoryRepository.findAll()) {
			
			CategoryResponse response = new CategoryResponse();
			
			response.setId(cat.getId());
			response.setName(cat.getName());
			
			
			cats.add(response);
			
		}
		
		return cats;
	}
	
}
