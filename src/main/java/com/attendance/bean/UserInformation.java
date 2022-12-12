package com.attendance.bean;

public class UserInformation {
    private String account;
    private String name;
    private String department;
    private String degree;
    private boolean sex;
    private String work;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public UserInformation() {
    }

    public UserInformation(String account, String name, String department, String degree, boolean sex, String work) {
        this.account = account;
        this.name = name;
        this.department = department;
        this.degree = degree;
        this.sex = sex;
        this.work = work;
    }
}
