package com.floionze.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.floionze.dao.authordao;
import com.floionze.dao.bookdao;
import com.floionze.model.book;
import com.floionze.model.author;
import com.floionze.model.crudsqlab;



public class abaction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String isbn;
    private String[] isbns;
    private String name;
    private String[] names;
    private book book;
    private List<book> books;
    private bookdao daob =  bookdao.getInstance();
    private author author;
    private List<author> authors;
    private authordao daoa = authordao.getInstance();
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String[] getIsbns() {
		return isbns;
	}
	public void setIsbns(String[] isbns) {
		this.isbns = isbns;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	public book getBook() {
		return book;
	}
	public void setBook(book book) {
		this.book = book;
	}
	public List<book> getBooks() {
		return books;
	}
	public void setBooks(List<book> books) {
		this.books = books;
	}
	public bookdao getDaob() {
		return daob;
	}
	public void setDaob(bookdao daob) {
		this.daob = daob;
	}
	public author getAuthor() {
		return author;
	}
	public void setAuthor(author author) {
		this.author = author;
	}
	public List<author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<author> authors) {
		this.authors = authors;
	}
	public authordao getDaoa() {
		return daoa;
	}
	public void setDaoa(authordao daoa) {
		this.daoa = daoa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	public String queryab() {
		if(name != null) {
			//query by author name
			author = daoa.getAuthor(name);
			return "namesuccess";
		}
		else if (isbn != null){
			//query by isbn
			book = daob.getBook(isbn);
			author = daoa.getAuthor(book.getAuthorid());
			return "isbnsuccess";
		}
		return SUCCESS;
	}

    public String listb() {
    	if(name != null) {
			//query by author name
			author = daoa.getAuthor(name);
			if(author != null) {
				//query by author name
		        books = daob.getBooks(author.getAuthorid());
		        return "namesuccess";
			}
    	}
        return SUCCESS;
    }
       
    public String storea() {
    	//addauthor.action
    	daoa.storeAuthor(author);
		return SUCCESS;
    }
    
    public String storeb() {
    	//test if author exists
    	author = daoa.getAuthor(author.getName());
    	if(author == null || author.getName() == null) {
    		author = new author();
    		author.setName(name);
    		return "newauthor";
    	}
    	//test if able to update
    	book.setAuthorid(author.getAuthorid());
        daob.storeBook(book);
        return SUCCESS;
    }
    
    public String updateb() {
    	//test if author exists
    	author = daoa.getAuthor(author.getName());
    	if(author == null || author.getName() == null) {
    		author = new author();
    		author.setName(name);
    		return "newauthor";
    	}
    	//test if able to update
    	book.setAuthorid(author.getAuthorid());
        daob.updateBook(book);
        return SUCCESS;
    }
    
    public String removeb() {
        if(null != isbn) {
            daob.removeBook(isbn);
            return "isbnsuccess";
        }
        return SUCCESS;
    }
	
    public String loadb() {
    	book = daob.getBook(isbn);
    	author = daoa.getAuthor(book.getAuthorid());
    	return SUCCESS;
    }

    public String initdb() {
    	crudsqlab csab = new crudsqlab();
    	csab.initdb();
    	return SUCCESS;
    }
}
