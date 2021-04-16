package com.project.eportal;

public class TasksData {

    private String TaskTitle;
    private String TaskDesc;

    public TasksData(String taskTitle, String taskDesc) {
        TaskTitle = taskTitle;
        TaskDesc = taskDesc;
    }

    public String getTaskTitle() {
        return TaskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        TaskTitle = taskTitle;
    }

    public String getTaskDesc() {
        return TaskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        TaskDesc = taskDesc;
    }
}

