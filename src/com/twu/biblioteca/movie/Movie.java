package com.twu.biblioteca.movie;

public class Movie {

    private String name;
    private int year;
    private String director;
    private int rating;


    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }
}
