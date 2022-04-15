package com.example.week8;


public class Book {
    private String _id;
    //private String author;
    private double price;
    //private int pages;
    private String name;
    private int categoryId;

    public Book(String _id, String name, int categoryId, double price) {
        this._id=_id;
        this.price = price;
        this.name = name;
        this.categoryId = categoryId;
    }
    public String get_id() {
        return _id;
    }
    public double getPrice() {
        return price;
    }
    public String getName(){
        return name;
    }
    public int getCategoryId() {
        return categoryId;
    }
}
