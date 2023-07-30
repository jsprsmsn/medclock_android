package com.example.medclock;

public class User {

    private String image, medicine, date, time;

    public User(){
    }

    public User(String medicine, String image, String date, String time) {
        this.medicine = medicine;
        this.image = image;
        this.date = date;
        this.time = time;
    }

    public String getMedicine() {return medicine; }
    public String getImage() {return image; }
    public String getDate() {return date; }
    public String getTime() {return time; }
}