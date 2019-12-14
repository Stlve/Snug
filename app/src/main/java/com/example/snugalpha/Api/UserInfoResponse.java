package com.example.snugalpha.Api;

public class UserInfoResponse {
    public  String msg;
    public  Data data;
    public UserInfoResponse(String msg,Data data){
        this.msg = msg;
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        public String name;
        public String telephone;
        public   int id;
        public int days;
        public int taskNum;
        public int taskFinishNum;

        public Data(int taskFinishNum,String name,int days,String telephone,int id,int taskNum){
            this.name = name;
            this.id=id;
            this.telephone = telephone;
            this.taskFinishNum = taskFinishNum;
            this.days = days;
            this.taskNum=taskNum;
        }

        public int getDays() {
            return days;
        }

        public int getTaskFinishNum() {
            return taskFinishNum;
        }

        public int getTaskNum() {
            return taskNum;
        }

        public void setDays(int days) {
            this.days = days;
        }

        public void setTaskFinishNum(int taskFinishNum) {
            this.taskFinishNum = taskFinishNum;
        }

        public void setTaskNum(int taskNum) {
            this.taskNum = taskNum;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getTelephone() {
            return telephone;
        }

        public int getId() {
            return id;
        }
    }

}
