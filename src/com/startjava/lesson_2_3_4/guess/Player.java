package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private int amountAttemps;
    private final int[] nums = new int[10];

    public Player(String name) {
        this.name = name;
    }

    public int getAmountAttempts() {
        return amountAttemps;
    }

    public int[] getNums() {
        return Arrays.copyOf(nums, amountAttemps);
    }

    public void addNum(int inputNum) {
        nums[amountAttemps] = inputNum;
        amountAttemps++;
    }

    public int getLastNum() {
        return nums[amountAttemps - 1];
    }

    public void clear() {
        Arrays.fill(nums, amountAttemps, amountAttemps, 0);
        amountAttemps = 0;
    }

    public String toString() {
        return name;
    }
}