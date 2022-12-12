package com.attendance.bean;

public class record {
    private String account;
    private String comeTime;
    private String exitTime;
    private int status;

    public record() {
    }

    public record(String account, String comeTime, String exitTime, int status) {
        this.account = account;
        this.comeTime = comeTime;
        this.exitTime = exitTime;
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getComeTime() {
        return comeTime;
    }

    public void setComeTime(String comeTime) {
        this.comeTime = comeTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
