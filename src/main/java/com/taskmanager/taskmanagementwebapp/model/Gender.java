package com.taskmanager.taskmanagementwebapp.model;

public class Gender {

    private int id;
    private String genderName;


    public Gender() {

    }

    public Gender(int id, String genderName) {
        this.id = id;
        this.genderName = genderName;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderName='" + genderName + '\'' +
                ", id=" + id +
                '}';
    }
}
