package com.example.snugalpha.Api;

public class viewSysTask {
    int userId;
    String catagory;
    public viewSysTask(int userId,String catagory) {
        this.userId = userId;
        this.catagory=catagory;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getCatagory() {
        return catagory;
    }
}
