package com.example.snugalpha.Utils;

public class UserDto {
    String name;
    String password;
    String telephone;
    public UserDto(String name, String telephone, String password){
        this.name = name;
        this.telephone=telephone;
        this.password=password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
