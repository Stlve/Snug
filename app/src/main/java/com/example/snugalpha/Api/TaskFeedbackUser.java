package com.example.snugalpha.Api;

public class TaskFeedbackUser {
    int userId;
    int score;
    int taskId;
    String taskFlag;
    public TaskFeedbackUser(int userId, int score,int taskId,String taskFlag) {
        this.userId = userId;
        this.score=score;
        this.taskFlag=taskFlag;
        this.taskId=taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskFlag() {
        return taskFlag;
    }

    public void setTaskFlag(String taskFlag) {
        this.taskFlag = taskFlag;
    }


}
