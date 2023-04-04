package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static double calculate(String mathExpression) throws NumberFormatException {
        String[] partsExpression = mathExpression.split(" ");
        double num = 0;
        char action = 0;
        double num2 = 0;
        try {
            num = Integer.parseInt(partsExpression[0]);
            action = partsExpression[1].charAt(0);
            num2 = Integer.parseInt(partsExpression[2]);

            if (num < 0 || num2 < 0 || partsExpression.length > 3) throw new NumberFormatException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Неккоректно введено выражение. Введите числа — целые, " +
                    "положительные! Формат: 2 + 2");
        }

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