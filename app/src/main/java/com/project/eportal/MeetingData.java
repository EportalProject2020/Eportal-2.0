package com.project.eportal;

import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
@IgnoreExtraProperties
public class MeetingData {
    private String id;
    private String title;
    private String link;
    private @ServerTimestamp Date timestamp;
    private String meeting_id;


    public MeetingData(String id, String title, String link) {
        this.title = title;
        this.link = link;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public String getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(String meeting_id) {
        this.meeting_id = meeting_id;
    }

}

