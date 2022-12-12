package com.attendance.bean;

public class User {
    private String user;
    private String password;
    private int user_type;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public User() {
    }

    public User(String user, String password, int user_type) {
        this.user = user;
        this.password = password;
        this.user_type = user_type;
    }
}
