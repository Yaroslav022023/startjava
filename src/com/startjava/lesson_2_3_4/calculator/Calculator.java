package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private double num;
    private double num2;
    private char[] action;

    void setNums(String nums) {
        if (nums != null) {
            splitNums(nums);
        }
    }

    private void splitNums(String nums) {
        String[] numsSplit = nums.split(" ");
        num = Double.parseDouble(numsSplit[0]);
        action = numsSplit[1].toCharArray();
        num2 = Double.parseDouble(numsSplit[2]);
    }

    public void calculate() {
        double result;
        switch(action[0]) {
            case '+':
                result = num + num2;
                break;
            case '-':
                result = num - num2;
                break;
            case '*':
                result = num * num2;
                break;
            case '/':
                result = num / num2;
                break;
            case '^':
                result = Math.pow(num, num2);
                break;
            case '%':
                result = num % num2;
                break;
            default:
                result = 0;
        }

        int integer = (int) result;
        System.out.printf(result - integer == 0 ? "%.0f %s" : "%.3f %s", result, "\n");
    }
}