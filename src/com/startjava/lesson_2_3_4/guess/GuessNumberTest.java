package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        inputName(1);
        String name1 = scanner.nextLine();
        inputName(2);
        String name2 = scanner.nextLine();
        inputName(3);
        String name3 = scanner.nextLine();

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

    private static void inputName(int numberPlayer) {
        System.out.printf("Введите имя %d-го игрока: ", numberPlayer);
    }
}