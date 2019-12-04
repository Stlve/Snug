package com.example.snugalpha.Utils;

public class UserTask {
    String info;
    String start;
    String end;
    int userId;
   public UserTask(String Info, String Start, String End, int UserId){
        this.info=Info;
        start=Start;
        end=End;
        userId=UserId;
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
