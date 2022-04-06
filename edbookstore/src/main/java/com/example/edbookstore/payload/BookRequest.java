package com.example.edbookstore.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.example.edbookstore.model.Category;


public class BookRequest {
	
	private Long id;
	
    @NotBlank
    @Size(max = 140)
    private String title;

    @NotBlank
    @Size(max = 140)
    private String price;

    @NotBlank
    @Size(max = 140)
    private String author;

    @NotBlank
    @Size(max = 140)
    private String language;

    @NotBlank
    @Size(max = 140)
    private String publisher;
    
    private Category category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


}

