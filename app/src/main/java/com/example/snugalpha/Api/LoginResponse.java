package com.example.snugalpha.Api;

public class LoginResponse {
  public String msg;
    public  Data data;

    public LoginResponse(String msg, Data data){
        this.data=data;
        this.msg=msg;
    }
    public static class Data{
       public  String name;
        public String telephone;
        public  int id;
        public Data(String name, String telephone, int id){
            this.id=id;
            this.name=name;
            this.telephone=telephone;
        }
        public static volatile Data datas;

        public static void setDatas(Data datas) {
            Data.datas = datas;
        }

        public static Data getDatas() {
            return datas;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getTelephone() {
            return telephone;
        }
    }
}
