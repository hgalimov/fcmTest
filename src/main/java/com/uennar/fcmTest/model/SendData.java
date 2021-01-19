package com.uennar.fcmTest.model;

public class SendData {
    private DataBody data;
    private String to;

    public DataBody getData() {
        return data;
    }

    public void setData(DataBody data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public SendData() {
    }

    public SendData(DataBody data, String to) {
        this.data = data;
        this.to = to;
    }
}
