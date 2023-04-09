package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player1 = addNamePlayer(1);
        String player2 = addNamePlayer(2);
        String player3 = addNamePlayer(3);

        GuessNumber guessNumber = new GuessNumber(player1, player2, player3);
        String answerYesNo = "yes";

        do {
            if (answerYesNo.equals("yes")) {
                guessNumber.start();
            }

            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answerYesNo = scanner.nextLine();
        } while (!answerYesNo.equals("no"));
    }

    private static String addNamePlayer(int numberPlayer) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите имя %d-го игрока: ", numberPlayer );
        return scanner.nextLine();
    }
}