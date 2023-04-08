package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static double calculate(String mathExpression) {
        String[] partsExpression = mathExpression.split(" ");
        double num;
        char action;
        double num2;

        if (partsExpression.length == 3) {
            num = Integer.parseInt(partsExpression[0]);
            action = partsExpression[1].charAt(0);
            num2 = Integer.parseInt(partsExpression[2]);
        } else {
            throw new NumberFormatException();
        }

        if (num <= 0 || num2 <= 0) throw new NumberFormatException();

        return switch (action) {
            case '+' -> num + num2;
            case '-' -> num - num2;
            case '*' -> num * num2;
            case '/' -> num / num2;
            case '^' -> Math.pow(num, num2);
            case '%' -> num % num2;
            default -> 0;
        };
    }
}