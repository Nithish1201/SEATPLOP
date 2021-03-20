package com.nithishkumar.seatplop.Model;

public class Events {

    String eventName_, from_, to_, stadiumId_, time_, session_, bookFrom_, eventContact_, bookedSeats_, ticketStartingPrice_;

    public Events() {
    }

    public Events(String eventName_, String from_, String to_, String stadiumId_, String time_, String session_, String bookFrom_, String eventContact_, String bookedSeats_, String ticketStartingPrice_) {
        this.eventName_ = eventName_;
        this.from_ = from_;
        this.to_ = to_;
        this.stadiumId_ = stadiumId_;
        this.time_ = time_;
        this.session_ = session_;
        this.bookFrom_ = bookFrom_;
        this.eventContact_ = eventContact_;
        this.bookedSeats_ = bookedSeats_;
        this.ticketStartingPrice_ = ticketStartingPrice_;
    }

    public String getEventName_() {
        return eventName_;
    }

    public void setEventName_(String eventName_) {
        this.eventName_ = eventName_;
    }

    public String getFrom_() {
        return from_;
    }

    public void setFrom_(String from_) {
        this.from_ = from_;
    }

    public String getTo_() {
        return to_;
    }

    public void setTo_(String to_) {
        this.to_ = to_;
    }

    public String getStadiumId_() {
        return stadiumId_;
    }

    public void setStadiumId_(String stadiumId_) {
        this.stadiumId_ = stadiumId_;
    }

    public String getTime_() {
        return time_;
    }

    public void setTime_(String time_) {
        this.time_ = time_;
    }

    public String getSession_() {
        return session_;
    }

    public void setSession_(String session_) {
        this.session_ = session_;
    }

    public String getBookFrom_() {
        return bookFrom_;
    }

    public void setBookFrom_(String bookFrom_) {
        this.bookFrom_ = bookFrom_;
    }

    public String getEventContact_() {
        return eventContact_;
    }

    public void setEventContact_(String eventContact_) {
        this.eventContact_ = eventContact_;
    }

    public String getBookedSeats_() {
        return bookedSeats_;
    }

    public void setBookedSeats_(String bookedSeats_) {
        this.bookedSeats_ = bookedSeats_;
    }

    public String getTicketStartingPrice_() {
        return ticketStartingPrice_;
    }

    public void setTicketStartingPrice_(String ticketStartingPrice_) {
        this.ticketStartingPrice_ = ticketStartingPrice_;
    }
}
