package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {

    private int secretNum;
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void start() {
        secretNum = (1 + (int) (Math.random() * 100));
        restartNumsArrPlayers();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Игра началась!");
        System.out.println("У каждого игрока по 10 попыток");

        do {
            do {
                System.out.print("Число угадывает игрок " + player1 + ": ");
                player1.setNum(scanner.nextInt());
            } while (!isValidNum(player1.getNum()));

            if (isGuessed(player1.getNum()))
                break;

            do {
                System.out.print("Число угадывает игрок " + player2 + ": ");
                player2.setNum(scanner.nextInt());
            } while (!isValidNum(player2.getNum()));
        } while (!isGuessed(player2.getNum()));
    }

    private boolean isValidNum(int numPlayer) {
        if (numPlayer < 1 || numPlayer > 100) {
            System.out.println("Введите число 1-100");
            return false;
        }
        return true;
    }

    private boolean isGuessed(int numPlayer) {
        if (numPlayer < secretNum) {
            System.out.println("Число " + numPlayer + " меньше того, что загадал компьютер");
        } else if (numPlayer > secretNum) {
            System.out.println("Число " + numPlayer + " больше того, что загадал компьютер");
        } else {
            if (player1.getNum() == secretNum) {
                System.out.println("Игрок " + player1 + " угадал число " + player1.getNum() +
                        " c " + player1.getAmountAttempts() + " попытки");
            } else {
                System.out.println("Игрок " + player2 + " угадал число " + player2.getNum() +
                        " c " + player2.getAmountAttempts() + " попытки");
            }

            allNumsPlayers(player1.getNumsArr(), player2.getNumsArr());
            return true;
        }

        if (player2.getAmountAttempts() == 10) {
            attemptsEndedPrint(player2);
            allNumsPlayers(player1.getNumsArr(), player2.getNumsArr());
            return true;
        } else if (player1.getAmountAttempts() == 10) {
            attemptsEndedPrint(player1);
        }
        return false;
    }

    private void allNumsPlayers(int[] numsPlayer1, int[] numsPlayer2) {
        for (int currentNum : numsPlayer1) {
            System.out.print(currentNum + " ");
        }
        System.out.println();
        for (int currentNum : numsPlayer2) {
            System.out.print(currentNum + " ");
        }
        System.out.println();
    }

    private void restartNumsArrPlayers() {
        player1.restartNumsArr();
        player2.restartNumsArr();
    }

    private void attemptsEndedPrint(Player name) {
        System.out.println("у " + name + " закончились попытки");
    }
}