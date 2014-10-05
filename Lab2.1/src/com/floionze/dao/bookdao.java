package com.floionze.dao;

import java.util.List;

import com.floionze.model.book;
import com.floionze.model.crudsqlab;

public class bookdao {
	private static final bookdao instance;
    
    static {
        instance = new bookdao();
        //init books in database bookdb here
        //create database if not exists bookdb
    }
    
    private bookdao() {}
    
    public static bookdao getInstance() {
        return instance;
    }
    
    public List<book> getBooks(int authorid) {
    	crudsqlab sqlab = new crudsqlab();
    	return sqlab.getlistb(authorid);
    }
    
    public book getBook(String isbn) {
    	crudsqlab sqlab = new crudsqlab();
    	return sqlab.getb(isbn);
    }
    
    public void storeBook(book book) {
    	crudsqlab sqlab = new crudsqlab();
    	sqlab.saveb(book);
    }
    
	public void updateBook(book book) {
		crudsqlab sqlab = new crudsqlab();
    	sqlab.updateb(book);
	}
        
    public void removeBook(String isbn) {
    	crudsqlab sqlab = new crudsqlab();
    	sqlab.deleteb(isbn);
    }

}
