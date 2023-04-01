package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String answerYesNo;

        do {
            System.out.print("Введите математическое выражение: ");
            calculator.setNums(scanner.nextLine());
            calculator.calculate();

            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answerYesNo = scanner.nextLine();

            if (answerYesNo.equals("no")) {
                break;
            }

        } while (answerYesNo.equals("yes"));
    }
}