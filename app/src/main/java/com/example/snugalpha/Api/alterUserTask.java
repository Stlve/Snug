package com.example.snugalpha.Api;

public class alterUserTask {
    String info;
    String start;
    String end;
    int userId;
    int taskId;
    alterUserTask(String Info, String Start, String End, int UserId,int taskId){
        info=Info;
        start=Start;
        end=End;
        userId=UserId;
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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
