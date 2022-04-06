package com.example.edbookstore.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edbookstore.model.Category;
import com.example.edbookstore.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
//	
	Optional<Category> findByName(String name);

    List<Category> findByIdIn(List<Long> categoryIds);

    Boolean existsByName(String name);
    
    Category save(Category category);
}
