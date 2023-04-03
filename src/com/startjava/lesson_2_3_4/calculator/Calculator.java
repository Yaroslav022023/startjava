package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public String calculate(String nums) {
        String[] numsSplit = nums.split(" ");
        double num = Integer.parseInt(numsSplit[0]);
        char[] action = numsSplit[1].toCharArray();
        double num2 = Integer.parseInt(numsSplit[2]);
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
        return result - integer == 0 ? String.format("%.0f", result) : String.format("%.3f", result);
    }
}