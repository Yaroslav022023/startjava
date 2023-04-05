package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {

    private int secretNum;
    private final Player player1;
    private final Player player2;
    private int currentPlayerFinished;

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
            } while (!player1.addNum(scanner.nextInt()));

            if (isGuessed(player1.currentNum(), player1))
                break;
            attemptsCheck(player1);

            do {
                System.out.print("Число угадывает игрок " + player2 + ": ");
            } while (!player2.addNum(scanner.nextInt()));
        } while (!isGuessed(player2.currentNum(), player2) && !attemptsCheck(player2));
    }

    private boolean isGuessed(int currentNumPlayer, Player player) {
        if (currentNumPlayer < secretNum) {
            System.out.println("Число " + currentNumPlayer + " меньше того, что загадал компьютер");
        } else if (currentNumPlayer > secretNum) {
            System.out.println("Число " + currentNumPlayer + " больше того, что загадал компьютер");
        } else {
            System.out.println("Игрок " + player + " угадал число " + player.currentNum() +
                    " c " + player.getAmountAttempts() + " попытки");

            outputAllNumsPlayers(player1.getNums());
            outputAllNumsPlayers(player2.getNums());
            return true;
        }
        return false;
    }

    private void outputAllNumsPlayers(int[] numsPlayer1) {
        for (int currentNum : numsPlayer1) {
            System.out.print(currentNum + " ");
        }
        System.out.println();
    }

    private void restartNumsArrPlayers() {
        player1.clear();
        player2.clear();
        currentPlayerFinished = 0;
    }

    private boolean attemptsCheck(Player player) {
        if (player.getAmountAttempts() == 10) {
            System.out.println("у " + player + " закончились попытки");
            ++currentPlayerFinished;
        }
        if (currentPlayerFinished == 2) {
            outputAllNumsPlayers(player1.getNums());
            outputAllNumsPlayers(player2.getNums());
            return true;
        }
        return false;
    }
}