package com.example.anew;

public class Helper1Class {

    String name, position, description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Helper1Class(String name, String position, String description) {
        this.name = name;
        this.position = position;
        this.description = description;
    }


}
