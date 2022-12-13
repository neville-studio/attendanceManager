package com.attendance.bean;

public class Record {
    private String account;
    private long comeTime;
    private long exitTime;
    private int status;
    private long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Record() {
    }

    public Record(String account, long comeTime, long exitTime, int status,long date) {
        this.account = account;
        this.comeTime = comeTime;
        this.exitTime = exitTime;
        this.status = status;
        this.date  = date;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getComeTime() {
        return comeTime;
    }

    public void setComeTime(long comeTime) {
        this.comeTime = comeTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
