package com.ecevents.earlhamcs.ecevents;

/**
 * Created by nirdeshbhandari on 4/5/17.
 */

public class Queries {
    private String event_id, title, location, c_person,email,odate,date,time,description;

    public Queries(String event_id, String title, String location, String c_person, String email, String odate,String date,String time, String description )
    {
        this.setEvent_id(event_id);
        this.setTitle(title);
        this.setLocation(location);
        this.setC_person(c_person);
        this.setOdate(odate);
        this.setEmail(email);
        this.setDate(date);
        this.setTime(time);
        this.setDescription(description);
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getC_person() {
        return c_person;
    }

    public void setC_person(String c_person) {
        this.c_person = c_person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

