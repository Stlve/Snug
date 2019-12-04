package com.example.snugalpha.Api;

public class viewTask {
    public int userId;
    public String date;
    public viewTask(int userId,String date){
        this.date = date;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
