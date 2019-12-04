package com.example.snugalpha.Api;

public class alterUserInfo {
    public int userId;
    public String name;
    public String passwordBefore;
    public String passwordAfter;
    public String telephone;
public alterUserInfo(int userId,String name,String passwordBefore,String passwordAfter,String telephone){
    this.name = name;
    this.passwordAfter = passwordAfter;
    this.passwordBefore = passwordBefore;
    this.telephone = telephone;
    this.userId = userId;
}
    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPasswordAfter(String passwordAfter) {
        this.passwordAfter = passwordAfter;
    }

    public void setPasswordBefore(String passwordBefore) {
        this.passwordBefore = passwordBefore;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPasswordAfter() {
        return passwordAfter;
    }

    public String getPasswordBefore() {
        return passwordBefore;
    }

}
