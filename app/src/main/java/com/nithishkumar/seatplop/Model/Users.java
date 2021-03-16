package com.nithishkumar.seatplop.Model;

public class Users {

    private String phoneNo, fullName, userName, email, password, date, age, gender, location;

    public Users() {
    }

    public Users(String phoneNo, String fullName, String userName, String email, String password, String date, String age, String gender, String location) {
        this.phoneNo = phoneNo;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.date = date;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
