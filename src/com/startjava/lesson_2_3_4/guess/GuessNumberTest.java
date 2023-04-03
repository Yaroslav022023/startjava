package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя Первого игрока: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Введите имя Второго игрока: ");
        Player player2 = new Player(scanner.nextLine());

        GuessNumber guessNumber = new GuessNumber(player1, player2);
        String answerYesNo = "yes";

        do {
            if (answerYesNo.equals("yes")) {
                guessNumber.start();
            }

            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answerYesNo = scanner.nextLine();
        } while (!answerYesNo.equals("no"));
    }
}