package com.example.snugalpha.Api;

import java.util.List;

public class viewDataResponse {
    String msg;
    int[] score;
    int[] data;
    int num;
    int userId;
    String startDate;

    public viewDataResponse(String msg,int[] score,int[] data,int num,int userId,String startDate){
        this.data = data;
        this.msg = msg;
        this.score = score;
        this.num = num;
        this.startDate = startDate;
        this.userId = userId;
    }
    public void setScore(int[] score) {
        this.score = score;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMsg() {
        return msg;
    }

    public int[] getData() {
        return data;
    }

    public int getUserId() {
        return userId;
    }

    public int getNum() {
        return num;
    }

    public int[] getScore() {
        return score;
    }

    public String getStartDate() {
        return startDate;
    }
}
