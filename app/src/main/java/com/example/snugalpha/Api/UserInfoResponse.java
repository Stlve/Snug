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

        public Data(String name,String telephone,int id){
            this.name = name;
            this.id=id;
            this.telephone = telephone;
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
