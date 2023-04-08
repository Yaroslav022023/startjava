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

    public boolean addNum(int num) {
        if (num > 0 && num <= 100) {
            nums[amountAttemps] = num;
            ++amountAttemps;
            return true;
        }
        System.out.println("Введите число 1-100");
        return false;
    }

    public int takeCurrentNum() {
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