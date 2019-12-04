package com.example.snugalpha.Api;


import java.util.List;

public class viewSysTaskResponse {
    public String msg;
   public List<Data> data;
    public int UserId;
    public viewSysTaskResponse(String msg , List<Data> data, int UserId) {
        this.msg = msg;
        this.data =data;
        this.UserId=UserId;
    }
    public int getUserId() {
        return UserId;
    }
    public void setUserId(int userId) {
        UserId = userId;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    static class Data{
        public String status;
        public int score;
        public String taskFlag;
        public  String taskInfo;
        public String taskCatagory;
        public  int taskId;
        public int taskOrder;
        public Data(int score,String taskFlag,String taskInfo,String taskCatagory,int taskId,String status,int taskOrder) {
            this.score=score;
            this.status=status;
            this.taskCatagory=taskCatagory;
            this.taskFlag=taskFlag;
            this.taskId=taskId;
            this.status = status;
            this.taskOrder=taskOrder;
        }
        public int getScore() {
            return score;
        }
        public void setScore(int score) {
            this.score = score;
        }
        public String getTaskFlag() {
            return taskFlag;
        }
        public void setTaskFlag(String taskFlag) {
            this.taskFlag = taskFlag;
        }
        public String getTaskInfo() {
            return taskInfo;
        }
        public void setTaskInfo(String taskInfo) {
            this.taskInfo = taskInfo;
        }
        public String getTaskCatagory() {
            return taskCatagory;
        }
        public void setTaskCatagory(String taskCatagory) {
            this.taskCatagory = taskCatagory;
        }
        public int getTaskId() {
            return taskId;
        }
        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public int getTaskOrder() {
            return taskOrder;
        }

        public void setTaskOrder(int taskOrder) {
            this.taskOrder = taskOrder;
        }

    }
}
