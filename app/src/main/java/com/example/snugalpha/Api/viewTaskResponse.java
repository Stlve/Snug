package com.example.snugalpha.Api;


public class viewTaskResponse {
    public String msg;
    public Data data;
    public int userId;
    public viewTaskResponse(String msg,Data data,int userId){
        this.msg=msg;
        this.data = data;
        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public Data getData() {
        return data;
    }

    public int getUserId() {
        return userId;
    }

    public static class Data{
        public String score;
        public String taskFlag;
        public String start;
        public String end;
        public String taskInfo;
        public String taskId;
        public String status;

        public Data(String score,String taskFlag,String start,String end,String taskInfo,String taskId,String status){
            this.score = score;
            this.taskFlag = taskFlag;
            this.start = start;
            this.end = end;
            this.taskInfo =taskInfo;
            this.taskId = taskId;
            this.status = status;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public void setTaskFlag(String taskFlag) {
            this.taskFlag = taskFlag;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public void setTaskInfo(String taskInfo) {
            this.taskInfo = taskInfo;
        }

        public String getStart() {
            return start;
        }

        public String getStatus() {
            return status;
        }

        public String getScore() {
            return score;
        }

        public String getEnd() {
            return end;
        }

        public String getTaskFlag() {
            return taskFlag;
        }

        public String getTaskId() {
            return taskId;
        }

        public String getTaskInfo() {
            return taskInfo;
        }
    }

}

