package com.project.eportal.IT;

public class ITRequestData {

    private String name;
    private String requestTitle;
    private String requestDescription;
    private String requestedid;

    public ITRequestData(String name, String title, String description, String requestedid) {
        this.name = name;
        this.requestTitle = title;
        this.requestDescription = description;
        this.requestedid = requestedid;
    }


    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    private String requestID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }
}
