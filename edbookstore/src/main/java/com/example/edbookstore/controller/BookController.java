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

import com.example.edbookstore.config.security.CurrentUser;
import com.example.edbookstore.config.security.UserPrincipal;
import com.example.edbookstore.exception.ResourceNotFoundException;
import com.example.edbookstore.model.Book;
import com.example.edbookstore.payload.BookRequest;
import com.example.edbookstore.payload.BookResponse;
import com.example.edbookstore.repository.BookRepository;
import com.example.edbookstore.service.BookService;


@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

	@PostMapping("/createbook")
    public BookRequest createBook(@Valid @RequestBody BookRequest request) {
        return bookService.createEditBook(request);
    }

    @GetMapping("/book/{bookId}")
    public BookResponse getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }
    
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {
    	return bookService.deleteBook(bookId);
    }


}
