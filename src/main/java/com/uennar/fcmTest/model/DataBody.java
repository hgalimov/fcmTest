package com.uennar.fcmTest.model;

public class DataBody {
    private String notification_title;
    private String notification_body;
    private String payload_title;
    private String payload_body;

    public String getNotification_title() {
        return notification_title;
    }

    public void setNotification_title(String notification_title) {
        this.notification_title = notification_title;
    }

    public String getNotification_body() {
        return notification_body;
    }

    public void setNotification_body(String notification_body) {
        this.notification_body = notification_body;
    }

    public String getPayload_title() {
        return payload_title;
    }

    public void setPayload_title(String payload_title) {
        this.payload_title = payload_title;
    }

    public String getPayload_body() {
        return payload_body;
    }

    public void setPayload_body(String payload_body) {
        this.payload_body = payload_body;
    }

    public DataBody() {
    }

    public DataBody(String notification_title, String notification_body, String payload_title, String payload_body) {
        this.notification_title = notification_title;
        this.notification_body = notification_body;
        this.payload_title = payload_title;
        this.payload_body = payload_body;
    }
}
