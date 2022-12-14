package com.attendance.bean;

public class RecordView {
    private String account;
    private long date;
    private String name;
    private long cometime;
    private long exitTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCometime() {
        return cometime;
    }

    public void setCometime(long cometime) {
        this.cometime = cometime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public RecordView() {
    }

    public RecordView(String account, long date, String name, long cometime, long exitTime) {
        this.account = account;
        this.date = date;
        this.name = name;
        this.cometime = cometime;
        this.exitTime = exitTime;
    }
}
