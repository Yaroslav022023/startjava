package com.startjava.lesson_2_3.guess;

public class Player {

    private String name;
    private int num;

    public Player(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String toString() {
        return name;
    }
}