package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = inputName(1);
        String name2 = inputName(2);
        String name3 = inputName(3);

        GuessNumber guessNumber = new GuessNumber(name1, name2, name3);
        String answerYesNo = "yes";

        do {
            if (answerYesNo.equals("yes")) {
                guessNumber.start();
            }

            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answerYesNo = scanner.nextLine();
        } while (!answerYesNo.equals("no"));
    }

    private static String inputName(int numberPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите имя %d-го игрока: ", numberPlayer);
        return scanner.nextLine();
    }
}