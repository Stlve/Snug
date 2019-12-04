package com.example.snugalpha.Api;

public class LoginUser {
    String password;
    String telephone;
    public LoginUser(String telephone, String password){
        this.telephone=telephone;
        this.password=password;
    }

    public String getTelephone() {
        return telephone;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
