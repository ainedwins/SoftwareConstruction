package com.example.edbookstore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import com.example.edbookstore.model.audit.DateAudit;


@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "title"
        })
})
public class Book extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String title;

    @NotBlank
    @Size(max = 15)
    private String price;

    
    @NotBlank
    @Size(max = 15)
    private String publisher;
    
    @NotBlank
    @Size(max = 15)
    private String author;

    @NotBlank
    @Size(max = 100)
    private String language;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    
	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn (name="cart_id",referencedColumnName="id",nullable=true,unique=true)
  	private Cart cart;
    
    public Book() {

    }
    

    public Book(String title, String price, String publisher, String author, String language, Category category) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.language = language;
        this.publisher = publisher;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
    
    public Category getCategory( ) {
    	return category;
    }
    
    public void setCategory(Category category) {
    	this.category = category;
    }

    
}
