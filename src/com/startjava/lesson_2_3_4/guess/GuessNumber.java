package com.startjava.lesson_2_3_4.guess;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private final Player[] players;
    private int secretNum;
    private int rounds;
    private int currentPlayerFinished;

    public GuessNumber(String... names) {
        players = new Player[names.length];

        for (int i = 0; i < names.length; i++) {
            players[i] = new Player(names[i]);
        }
        shuffleQueue(players);
    }

    void start() {
        secretNum = (1 + (int) (Math.random() * 100));
        clearPlayers();
        rounds++;

        System.out.println("Игра началась!");
        System.out.println("У каждого игрока по 10 попыток. Всего 3 раунда! Раунд " + rounds);

        boolean isGuessed = false;
        do {
            for (Player player : players) {
                inputNum(player);
                if (checkGuessedNum(player)) {
                    for (Player currentPlayer : players) {
                        outputAllNumsPlayers(currentPlayer.getNums());
                    }
                    player.setScore();
                    if (rounds == 3) {
                        winnerCheck();
                    }
                    isGuessed = true;
                    break;
                }
                attemptsCheck(player);
            }
        } while (!isGuessed && currentPlayerFinished != players.length);
    }

    private void shuffleQueue(Player[] players) {
        Random rand = new Random();

        for (int i = 0; i < players.length - 1; i++) {
            int j = i + rand.nextInt(players.length - i);
            Player temp = players[i];
            players[i] = players[j];
            players[j] = temp;
        }
    }

    private void clearPlayers() {
        for (Player player : players) {
            player.clear();
        }
        currentPlayerFinished = 0;

        if(rounds == 3) {
            rounds = 0;
            for (Player player : players) {
                player.clearScore();
            }
        }
    }

    private void inputNum(Player player) {
        Scanner scanner = new Scanner(System.in);
        int inputNum;

        do {
            System.out.print("Число угадывает игрок " + player + ": ");
            inputNum = scanner.nextInt();

            if (!player.addNum(inputNum)) {
                System.out.println("Введите число 1-100");
            }
        } while (inputNum < 1 || inputNum > 100);
    }

    private boolean checkGuessedNum(Player player) {
        if (player.getLastNum() == secretNum) {
            System.out.println("Игрок " + player + " угадал число " + player.getLastNum() +
                    " c " + player.getAmountAttempts() + " попытки");
            return true;
        }
        System.out.println("Число " + player.getLastNum() + (player.getLastNum() < secretNum ?
                " меньше" : " больше") + " того, что загадал компьютер");
        return false;
    }

    private void attemptsCheck(Player player) {
        if (player.getAmountAttempts() == 10) {
            System.out.println("у " + player + " закончились попытки");
            currentPlayerFinished++;
        }
        attemptsEnded();
    }

    private void outputAllNumsPlayers(int[] numsPlayer1) {
        for (int currentNum : numsPlayer1) {
            System.out.print(currentNum + " ");
        }
        System.out.println();
    }

    private void winnerCheck() {
        int[] scoresPlayers = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            scoresPlayers[i] = players[i].getScore();
        }

        int indexOfWinner = 0;
        int draw = 1;

        for (int i = 1; i < scoresPlayers.length; i++) {
            if (scoresPlayers[i] > scoresPlayers[indexOfWinner]) {
                indexOfWinner = i;
            } else if (scoresPlayers[indexOfWinner] == scoresPlayers[i]) {
                draw++;
            }
        }

        if (draw == 1 || indexOfWinner > 0) {
            System.out.println("По итогам 3 раундов победил игрок: " + players[indexOfWinner]);
        } else {
            System.out.printf("По итогам 3 раундов - %d игрока сыграли в ничью: " + "\n", draw);
        }
    }

    private void attemptsEnded() {
        if (currentPlayerFinished == players.length) {
            if (rounds != 3) {
                System.out.println("У всех игроков закончились попытки. Переходите " +
                        "к следующему раунду.");
            } else {
                System.out.println("У всех игроков закончились попытки.");
                winnerCheck();
            }

            for (Player player : players) {
                outputAllNumsPlayers(player.getNums());
            }
        }
    }
}