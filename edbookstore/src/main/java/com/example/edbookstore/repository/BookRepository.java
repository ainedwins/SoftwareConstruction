package com.example.edbookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edbookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);

    List<Book> findByIdIn(List<Long> bookIds);

    Boolean existsByTitle(String title);
    
}