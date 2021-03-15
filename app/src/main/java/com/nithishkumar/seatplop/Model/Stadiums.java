package com.nithishkumar.seatplop.Model;

public class Stadiums {

    String name, location, totalNoOfSeats, typeOfSport, surfaceArea, rating,state;

    public Stadiums() {
    }

    public Stadiums(String name, String location, String totalNoOfSeats, String typeOfSport, String surfaceArea, String rating, String state) {
        this.name = name;
        this.location = location;
        this.totalNoOfSeats = totalNoOfSeats;
        this.typeOfSport = typeOfSport;
        this.surfaceArea = surfaceArea;
        this.rating = rating;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTotalNoOfSeats() {
        return totalNoOfSeats;
    }

    public void setTotalNoOfSeats(String totalNoOfSeats) {
        this.totalNoOfSeats = totalNoOfSeats;
    }

    public String getTypeOfSport() {
        return typeOfSport;
    }

    public void setTypeOfSport(String typeOfSport) {
        this.typeOfSport = typeOfSport;
    }

    public String getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(String surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
