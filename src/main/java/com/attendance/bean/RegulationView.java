package com.attendance.bean;

public class RegulationView {
    private String account;
    private String name;
    private long comeTime;
    private long exitTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public RegulationView() {
    }

    public RegulationView(String account, String name, long comeTime, long exitTime) {
        this.account = account;
        this.name = name;
        this.comeTime = comeTime;
        this.exitTime = exitTime;
    }
}
