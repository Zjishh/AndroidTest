package com.example.test9_addressbook;

public class Person {
    public Person(String number, String name, int img) {
        this.number = number;
        this.name = name;
        this.img = img;
    }

    public Person() {
    }

    private String number;
    private String name;

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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private int img;
}
