package com.nithishkumar.seatplop.Model;

public class Events {

    String name, from, to, time, stadiumName, bookedSeats, notBookedSeats;

    public Events() {
    }

    public Events(String name, String from, String to, String time, String stadiumName, String bookedSeats, String notBookedSeats) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.time = time;
        this.stadiumName = stadiumName;
        this.bookedSeats = bookedSeats;
        this.notBookedSeats = notBookedSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(String bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public String getNotBookedSeats() {
        return notBookedSeats;
    }

    public void setNotBookedSeats(String notBookedSeats) {
        this.notBookedSeats = notBookedSeats;
    }
}
