package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private static final int CAPACITY = 10;
    private final String name;
    private final int[] nums = new int[CAPACITY];
    private int amountAttemps;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public int[] getNums() {
        return Arrays.copyOf(nums, amountAttemps);
    }

    public boolean addNum(int inputNum) {
        if (inputNum >= GuessNumber.START_RANGE && inputNum <= GuessNumber.END_RANGE) {
            nums[amountAttemps] = inputNum;
            amountAttemps++;
            return true;
        }
        System.out.println("Введите число 1-100");
        return false;
    }

    public int getLastNum() {
        return nums[amountAttemps - 1];
    }

    public int getAmountAttempts() {
        return amountAttemps;
    }

    public int getScore() {
        return score;
    }

    public void upScore() {
        score++;
    }

    public void clearScore() {
        score = 0;
    }

    public void clear() {
        Arrays.fill(nums, 0, amountAttemps, 0);
        amountAttemps = 0;
    }

    public String toString() {
        return name;
    }
}