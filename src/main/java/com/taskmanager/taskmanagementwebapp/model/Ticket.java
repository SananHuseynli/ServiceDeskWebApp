package com.taskmanager.taskmanagementwebapp.model;

import java.util.Date;

public class Ticket {

    private int id;
    private String title;
    private String description;
    private Status status_id;
    private Users user_id;
    public Date created;
    public Date updated;

    public Ticket() {
    }

    public Ticket(int id, String title, String description, Status status_id, Users user_id, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status_id = status_id;
        this.user_id = user_id;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Status status_id) {
        this.status_id = status_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}