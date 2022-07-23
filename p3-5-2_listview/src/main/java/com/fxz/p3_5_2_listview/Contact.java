package com.fxz.p3_5_2_listview;

public class Contact {
    private String name;
    private String number;
    private int imageId;

    public Contact(String name, String number, int imageId) {
        this.name = name;
        this.number = number;
        this.imageId = imageId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
