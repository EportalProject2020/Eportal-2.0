package com.project.eportal.calendar.activities;

public class CalendarData {

    private String fromDate;
    private String toDate;
    private String type;

    public CalendarData(String fromDate, String toDate, String type) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.type = type;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
