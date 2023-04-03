package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String NAME;
    private int num;
    private int amountAttemps;
    private int[] numsArr = new int[10];

    public Player(String name) {
        this.NAME = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        if (num > 0 && num <= 100) {
            numsArr[amountAttemps] = num;
            ++amountAttemps;
        }
    }

    public int getAmountAttempts() {
        return amountAttemps;
    }

    public int[] getNumsArr() {
        return Arrays.copyOf(numsArr, amountAttemps);
    }

    public void restartNumsArr() {
        Arrays.fill(numsArr, amountAttemps, amountAttemps, 0);
        amountAttemps = 0;
    }

    public String toString() {
        return NAME;
    }
}