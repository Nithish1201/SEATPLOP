package com.nithishkumar.seatplop.Model;

public class Events {

    private String name, from, to, time, stadium, bookedSeats, notBookedSeats;

    public Events() {
    }

    public Events(String name, String from, String to, String time, String stadium, String bookedSeats, String notBookedSeats) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.time = time;
        this.stadium = stadium;
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

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
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
