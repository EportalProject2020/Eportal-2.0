package com.project.eportal.employee;

public class UserITRequestData {
    private String title;
    private String descreption;
    private String name;
    private String id;

    public UserITRequestData(String title, String descreption, String name, String id) {
        this.title = title;
        this.descreption = descreption;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
}
