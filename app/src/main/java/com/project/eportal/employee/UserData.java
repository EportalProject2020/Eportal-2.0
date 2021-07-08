package com.project.eportal.employee;

public class UserData {

    private String email;
    private String name;
    private String password;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserData(String email, String name, String password, String id) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.id = id;
    }
}
