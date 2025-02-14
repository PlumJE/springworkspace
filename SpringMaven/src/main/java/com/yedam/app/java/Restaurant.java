package com.yedam.app.java;

public class Restaurant {
    private Chef chef;
    
    Restaurant(Chef chef){
    	this.chef = chef;
    }
    
    public void run() {
    	chef.cooking();
    }
}
