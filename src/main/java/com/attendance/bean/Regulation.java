package com.attendance.bean;

public class Regulation {
    private String account;
    private long comeTime;
    private long ExitTime;

    public Regulation() {
    }

    public Regulation(String account, long comeTime, long exitTime) {
        this.account = account;
        this.comeTime = comeTime;
        ExitTime = exitTime;
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
        return ExitTime;
    }

    public void setExitTime(long exitTime) {
        ExitTime = exitTime;
    }
}
