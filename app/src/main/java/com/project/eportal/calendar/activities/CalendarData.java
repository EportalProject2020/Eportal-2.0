package com.project.eportal.calendar.activities;

public class CalendarData {

    private String fromDate;
    private String toDate;
    private String type;
    private String employeeName;

    public CalendarData(String employeeName, String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.employeeName =employeeName;
        this.toDate = toDate;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public CalendarData(String fromDate, String toDate, String type, String employeeName) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.type = type;
        this.employeeName = employeeName;
    }
}
