package com.portfolio;


import java.util.Date;

public class Asset {

    public String description;
    public Value value;
    public Date date;

    public Asset(String description, Date date, Value value) {
        this.description = description;
        this.value = value;
        this.date = date;
    }
}

