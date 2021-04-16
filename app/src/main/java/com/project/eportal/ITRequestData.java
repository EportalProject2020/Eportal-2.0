package com.project.eportal;

public class ITRequestData {

    private String requestTitle;
    private String requestDescription;

    public ITRequestData(String requestTitle, String requestDescription) {
        this.requestTitle = requestTitle;
        this.requestDescription = requestDescription;
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
