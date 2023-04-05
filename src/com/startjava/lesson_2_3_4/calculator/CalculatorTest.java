package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answerYesNo = "yes";

        do {
            if (answerYesNo.equals("yes")) {
                double result;
                System.out.print("Введите математическое выражение: ");
                try {
                    result = Calculator.calculate(scanner.nextLine());
                    System.out.printf(result % 1 == 0 ? "%.0f %s" : "%.3f %s", result, "\n");
                } catch (NumberFormatException e) {
                    System.out.println("Некорректно введено выражение. Введите числа — целые, " +
                            "положительные! Формат: 2 + 2");
                }
            }

            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answerYesNo = scanner.nextLine();
        } while (!answerYesNo.equals("no"));
    }
}