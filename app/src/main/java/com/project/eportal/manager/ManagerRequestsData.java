package com.project.eportal.manager;

public class ManagerRequestsData {

    private String title;
    private String descreption;
    private String name;
    private String requestID;

    public ManagerRequestsData(String title, String descreption, String name, String requestID) {
        this.title = title;
        this.descreption = descreption;
        this.name = name;
        this.requestID = requestID;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
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
