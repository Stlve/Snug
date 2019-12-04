package com.example.snugalpha.Utils;

public class Task {

    private String title;

    private String detail;

    public Task(String title,String detail){

        this.title = title;

        this.detail = detail;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

}
