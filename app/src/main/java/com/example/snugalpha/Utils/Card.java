package com.example.snugalpha.Utils;

public class Card {
    private String name;
    private int imagedId;

    public int getImagedId() {
        return imagedId;
    }

    public String getName() {
        return name;
    }

    public void setImagedId(int imagedId) {
        this.imagedId = imagedId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Card(String a, int b){
        name = a;
        imagedId = b;
    }
}
