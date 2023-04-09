package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private int secretNum;
    private final Player[] players;
    private final int[] quantityWins;
    private int currentPlayerFinished;
    private int rounds;

    public GuessNumber(String... players) {
        this.players = new Player[players.length];

        for (int i = 0; i < players.length; i++) {
            this.players[i] = new Player(players[i]);
        }
        shuffleQueue(this.players);
        quantityWins = new int[players.length];
    }

    void start() {
        secretNum = (1 + (int) (Math.random() * 10));
        clearPlayers();
        rounds++;

        System.out.println("Игра началась!");
        System.out.println("У каждого игрока по 10 попыток. Всего 3 раунда! Раунд " + rounds);

        boolean winner = false;
        do {
            for (Player player : players) {
                inputNum(player);
                if (isGuessed(player.getLastNum(), player)) {
                    winner = true;
                    break;
                }
                attemptsCheck(player);
            }
        } while (!winner && currentPlayerFinished != players.length);
    }

    private void shuffleQueue(Player[] players) {
        for (int i = 0; i <= players.length - 2; i++) {
            Random rand = new Random();
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
            Arrays.fill(quantityWins, 0);
        }
    }

    private void inputNum(Player player) {
        Scanner scanner = new Scanner(System.in);
        int inputNum;

        do {
            System.out.print("Число угадывает игрок " + player + ": ");
            inputNum = scanner.nextInt();

            if (inputNum < 1 || inputNum > 100) {
                System.out.println("Введите число 1-100");
            }
        } while (inputNum < 1 || inputNum > 100);

        player.addNum(inputNum);
    }

    private boolean isGuessed(int currentNumPlayer, Player player) {
        if (currentNumPlayer == secretNum) {
            System.out.println("Игрок " + player + " угадал число " + player.getLastNum() +
                    " c " + player.getAmountAttempts() + " попытки");

            for (Player each : players) {
                outputAllNumsPlayers(each.getNums());
            }
            winnerCheck(player);
            return true;
        }

        System.out.println("Число " + currentNumPlayer + (currentNumPlayer < secretNum ?
                " меньше" : " больше") + " того, что загадал компьютер");
        return false;
    }

    private boolean attemptsCheck(Player player) {
        if (player.getAmountAttempts() == 10) {
            System.out.println("у " + player + " закончились попытки");
            ++currentPlayerFinished;
        }
        return attemptsEnded();
    }

    private void outputAllNumsPlayers(int[] numsPlayer1) {
        for (int currentNum : numsPlayer1) {
            System.out.print(currentNum + " ");
        }
        System.out.println();
    }

    private void winnerCheck(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == player) {
                quantityWins[i]++;
            }
        }

        if (rounds == 3) {
            int indexOfWinner = 0;
            int draw = 0;

            for (int i = 1; i < quantityWins.length; i++) {
                if (quantityWins[i] > quantityWins[indexOfWinner]) {
                    indexOfWinner = i;
                } else if (quantityWins[indexOfWinner] == quantityWins[i] ) {
                    draw++;
                }
            }

            if (draw == 0 || indexOfWinner > 0) {
                outputWinnerCheck(indexOfWinner);
            } else {
                outputDrawWinnerCheck();
            }
        }
    }

    private boolean attemptsEnded() {
        if (currentPlayerFinished == players.length) {
            System.out.println("У всех игроков закончились попытки. Переходите " +
                    "к следующему раунду.");
            for (Player player : players) {
                outputAllNumsPlayers(player.getNums());
            }
            return true;
        }
        return false;
    }

    private void outputWinnerCheck(int indexOfWinner) {
        for (Player player : players) {
            if (player == players[indexOfWinner]) {
                System.out.println("По итогам 3 раундов победил игрок: " + player);
            }
        }
    }

    private void outputDrawWinnerCheck() {
        int drawAmountPlayers = 0;

        for (int i = 0; i < quantityWins.length; i++) {
            for (int j = i + 1; j < quantityWins.length; j++) {
                if (quantityWins[i] == quantityWins[j]) {
                    drawAmountPlayers++;
                }
            }
        }
        System.out.printf("По итогам 3 раундов - %d игрока сыграли в ничью: " + "\n",
                drawAmountPlayers);
    }
}