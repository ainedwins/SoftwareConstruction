package com.example.edbookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edbookstore.config.security.UserPrincipal;
import com.example.edbookstore.exception.ResourceNotFoundException;
import com.example.edbookstore.model.Book;
import com.example.edbookstore.payload.BookRequest;
import com.example.edbookstore.payload.BookResponse;
import com.example.edbookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public BookRequest createEditBook(BookRequest bookRequest) {
		
		Optional<Book> existingBook  = bookRequest.getId() != null ? bookRepository.findById(bookRequest.getId()) :
			Optional.empty();
		
		
        
		Book book = existingBook.isPresent() ? existingBook.get() :  new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublisher(bookRequest.getPublisher());
        book.setAuthor(bookRequest.getAuthor());
        book.setLanguage(bookRequest.getLanguage());
        
        try {
        	book.setCategory(bookRequest.getCategory());
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
        
        return bookRepository.save(book) != null ? bookRequest : null;
    }
	

	public List<BookResponse> getAllBooks() {
		List<BookResponse> books = new ArrayList<>();
		
		for(Book book : bookRepository.findAll()) {
			
			BookResponse response = new BookResponse();
			
			response.setId(book.getId());
			response.setTitle(book.getTitle());
			response.setPrice(book.getPrice());
			response.setPublisher(book.getPublisher());
			response.setLanguage(book.getLanguage());
			response.setAuthor(book.getAuthor());
			response.setCategory(book.getCategory());
			
			books.add(response);
			
		}
		
		return books;
	}
	
	
	public BookResponse getBookById(Long bookId) {
		
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("bookId " + bookId + " not found", null, bookId));
        
        BookResponse response = new BookResponse();
        
        response.setId(book.getId());
		response.setTitle(book.getTitle());
		response.setPrice(book.getPrice());
		response.setPublisher(book.getPublisher());
		response.setAuthor(book.getAuthor());

        return response;
    }
	
	
	public String deleteBook(Long bookId) {
		
		Optional<Book> del = bookId != null ? bookRepository.findById(bookId) : Optional.empty();
		if(del.isPresent()) {
			
			try {
				
				bookRepository.delete(del.get());
				return "Deleted";
				
			} catch (Exception e) {
				
				return "Not Deleted";
			}
			
		}
		return "Not Deleted";
	}


}
