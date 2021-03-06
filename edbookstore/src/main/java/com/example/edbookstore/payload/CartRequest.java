package com.example.edbookstore.payload;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.edbookstore.model.Book;
import com.example.edbookstore.model.User;

public class CartRequest {
	
	private Long id;
	
    @NotBlank
    @Size(max = 140)
    private String name;
    
    @NotBlank
    @Size(max = 15)
    private double quantity;
	
	@NotBlank
	@Size(max = 15)
    private double total;
	
	@NotBlank
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
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

	public void setProducts(Set<Book> books) {
		this.books = books;
	}
	
	
}
