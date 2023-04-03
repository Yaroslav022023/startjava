package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String answerYesNo = "yes";

        do {
            if (answerYesNo.equals("yes")) {
                System.out.print("Введите математическое выражение: ");
                System.out.println(calculator.calculate(scanner.nextLine()));
            }

            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answerYesNo = scanner.nextLine();
        } while (!answerYesNo.equals("no"));
    }
}