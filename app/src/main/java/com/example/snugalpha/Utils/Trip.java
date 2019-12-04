package com.example.snugalpha.Utils;

public class Trip {

    private int image_id;

    private String text_1;

    private String text_2;

    private int num_1;

    private int num_2;

    public Trip(int image_id,String text_1,String text_2,int num_1,int num_2){
        this.image_id = image_id;
        this.text_1 = text_1;
        this.text_2 = text_2;
        this.num_1 = num_1;
        this.num_2 = num_2;
    }


    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setText_1(String text_1) {
        this.text_1 = text_1;
    }

    public String getText_1() {
        return text_1;
    }

    public void setText_2(String text_2) {
        this.text_2 = text_2;
    }

    public String getText_2() {
        return text_2;
    }

    public void setNum_1(int num_1) {
        this.num_1 = num_1;
    }

    public int getNum_1() {
        return num_1;
    }

    public void setNum_2(int num_2) {
        this.num_2 = num_2;
    }

    public int getNum_2() {
        return num_2;
    }

}
