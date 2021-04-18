package com.nithishkumar.seatplop.Model;

public class Tickets {

    String date_,month_,year_,time_,noOfSeats_,eventId_,standName_,seatNos_;

    public Tickets() {
    }

    public Tickets(String date_, String month_, String year_, String time_, String noOfSeats_, String eventId_, String standName_, String seatNos_) {
        this.date_ = date_;
        this.month_ = month_;
        this.year_ = year_;
        this.time_ = time_;
        this.noOfSeats_ = noOfSeats_;
        this.eventId_ = eventId_;
        this.standName_ = standName_;
        this.seatNos_ = seatNos_;
    }

    public String getDate_() {
        return date_;
    }

    public void setDate_(String date_) {
        this.date_ = date_;
    }

    public String getMonth_() {
        return month_;
    }

    public void setMonth_(String month_) {
        this.month_ = month_;
    }

    public String getYear_() {
        return year_;
    }

    public void setYear_(String year_) {
        this.year_ = year_;
    }

    public String getTime_() {
        return time_;
    }

    public void setTime_(String time_) {
        this.time_ = time_;
    }

    public String getNoOfSeats_() {
        return noOfSeats_;
    }

    public void setNoOfSeats_(String noOfSeats_) {
        this.noOfSeats_ = noOfSeats_;
    }

    public String getEventId_() {
        return eventId_;
    }

    public void setEventId_(String eventId_) {
        this.eventId_ = eventId_;
    }

    public String getStandName_() {
        return standName_;
    }

    public void setStandName_(String standName_) {
        this.standName_ = standName_;
    }

    public String getSeatNos_() {
        return seatNos_;
    }

    public void setSeatNos_(String seatNos_) {
        this.seatNos_ = seatNos_;
    }
}
