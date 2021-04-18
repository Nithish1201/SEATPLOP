package com.nithishkumar.seatplop.Model;

public class Time {

    String time,session;

    public Time() {
    }

    public Time(String time, String session) {
        this.time = time;
        this.session = session;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
