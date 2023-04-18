package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private static final int MAX_SIZE_NUMS = 10;
    private static final int MIN_INPUT_NUM = 1;
    private static final int MAX_INPUT_NUM = 100;
    private final String name;
    private final int[] nums = new int[MAX_SIZE_NUMS];
    private int amountAttemps;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public int getAmountAttempts() {
        return amountAttemps;
    }

    public int[] getNums() {
        return Arrays.copyOf(nums, amountAttemps);
    }

    public boolean addNum(int inputNum) {
        if (inputNum >= MIN_INPUT_NUM && inputNum <= MAX_INPUT_NUM) {
            nums[amountAttemps] = inputNum;
            amountAttemps++;
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        score++;
    }

    public void clearScore() {
        score = 0;
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