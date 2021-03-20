package com.nithishkumar.seatplop.Model;

public class Stadiums {

    String stadiumName_ , state_ , city_ , id_ , capacity_ , typeOfSport_ , surfaceArea_ , stadiumContact_ , rating_ , establishmentYear_;

    public Stadiums() {
    }

    public Stadiums(String stadiumName_, String state_, String city_, String id_, String capacity_, String typeOfSport_, String surfaceArea_, String stadiumContact_, String rating_, String establishmentYear_) {
        this.stadiumName_ = stadiumName_;
        this.state_ = state_;
        this.city_ = city_;
        this.id_ = id_;
        this.capacity_ = capacity_;
        this.typeOfSport_ = typeOfSport_;
        this.surfaceArea_ = surfaceArea_;
        this.stadiumContact_ = stadiumContact_;
        this.rating_ = rating_;
        this.establishmentYear_ = establishmentYear_;
    }

    public String getStadiumName_() {
        return stadiumName_;
    }

    public void setStadiumName_(String stadiumName_) {
        this.stadiumName_ = stadiumName_;
    }

    public String getState_() {
        return state_;
    }

    public void setState_(String state_) {
        this.state_ = state_;
    }

    public String getCity_() {
        return city_;
    }

    public void setCity_(String city_) {
        this.city_ = city_;
    }

    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }

    public String getCapacity_() {
        return capacity_;
    }

    public void setCapacity_(String capacity_) {
        this.capacity_ = capacity_;
    }

    public String getTypeOfSport_() {
        return typeOfSport_;
    }

    public void setTypeOfSport_(String typeOfSport_) {
        this.typeOfSport_ = typeOfSport_;
    }

    public String getSurfaceArea_() {
        return surfaceArea_;
    }

    public void setSurfaceArea_(String surfaceArea_) {
        this.surfaceArea_ = surfaceArea_;
    }

    public String getStadiumContact_() {
        return stadiumContact_;
    }

    public void setStadiumContact_(String stadiumContact_) {
        this.stadiumContact_ = stadiumContact_;
    }

    public String getRating_() {
        return rating_;
    }

    public void setRating_(String rating_) {
        this.rating_ = rating_;
    }

    public String getEstablishmentYear_() {
        return establishmentYear_;
    }

    public void setEstablishmentYear_(String establishmentYear_) {
        this.establishmentYear_ = establishmentYear_;
    }
}
