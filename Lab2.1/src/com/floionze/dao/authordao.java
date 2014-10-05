package com.floionze.dao;

import com.floionze.model.author;
import com.floionze.model.crudsqlab;

public class authordao {
	private static final authordao instance;
    
    static {
        instance = new authordao();
        //init authors in database bookdb here
    }
    
    private authordao() {}
    
    public static authordao getInstance() {
        return instance;
    }
    
    public author getAuthor(String name) {
    	crudsqlab sqlab = new crudsqlab();
    	return sqlab.geta(name);
    }
    
    public author getAuthor(int authorid) {
    	crudsqlab sqlab = new crudsqlab();
    	return sqlab.geta(authorid);
    }
    
    public void storeAuthor(author author) {
    	crudsqlab sqlab = new crudsqlab();
    	sqlab.savea(author);
    }
    
}
