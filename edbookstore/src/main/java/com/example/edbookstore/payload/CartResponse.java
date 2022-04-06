package com.example.edbookstore.payload;

import java.util.Set;

import com.example.edbookstore.model.Book;
import com.example.edbookstore.model.User;

public class CartResponse {
	private Long id;
    private String name;
    private String quantity;
    private double total;
    private User user;
    private Set<Book> books;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
    
    
}
