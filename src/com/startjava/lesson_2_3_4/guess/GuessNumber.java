package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private int secretNum;
    private final Player[] players;
    private int currentPlayerFinished;
    private int rounds;
    private int winPl1;
    private int winPl2;
    private int winPl3;

    public GuessNumber(Player... players) {
        this.players = new Player[players.length];
        System.arraycopy(players, 0, this.players, 0, players.length);
        shuffleQueue(this.players);
    }

    void start() {
        secretNum = (1 + (int) (Math.random() * 100));
        restartNumsArrPlayers();
        rounds++;

        System.out.println("Игра началась!");
        System.out.println("У каждого игрока по 10 попыток. Всего 3 раунда! Раунд " + rounds);

        do {
            inputNumPlayer(players[0]);
            if (isGuessed(players[0].takeCurrentNum(), players[0])) break;
            attemptsCheck(players[0]);

            inputNumPlayer(players[1]);
            if (isGuessed(players[1].takeCurrentNum(), players[1])) break;
            attemptsCheck(players[1]);

            inputNumPlayer(players[2]);
            if (isGuessed(players[2].takeCurrentNum(), players[2])) break;
        } while (!attemptsCheck(players[2]));
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

    private void restartNumsArrPlayers() {
        players[0].clear();
        players[1].clear();
        players[2].clear();
        currentPlayerFinished = 0;

        if(rounds == 3) {
            rounds = 0;
            winPl1 = 0;
            winPl2 = 0;
            winPl3 = 0;
        }
    }

    private void inputNumPlayer(Player player) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Число угадывает игрок " + player + ": ");
        } while (!player.addNum(scanner.nextInt()));
    }

    private boolean isGuessed(int currentNumPlayer, Player player) {
        if (currentNumPlayer == secretNum) {
            System.out.println("Игрок " + player + " угадал число " + player.takeCurrentNum() +
                    " c " + player.getAmountAttempts() + " попытки");

            outputAllNumsPlayers(players[0].getNums());
            outputAllNumsPlayers(players[1].getNums());
            outputAllNumsPlayers(players[2].getNums());
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
        if (players[0] == player) {
            ++winPl1;
        } else if (players[1] == player) {
            ++winPl2;
        } else {
            ++winPl3;
        }

        if (rounds == 3) {
            if (winPl1 > winPl2 && winPl1 > winPl3) {
                outputWinnerCheck(players[0]);
            } else if (winPl2 > winPl1 && winPl2 > winPl3) {
                outputWinnerCheck(players[1]);
            } else if (winPl3 > winPl1 && winPl3 > winPl2) {
                outputWinnerCheck(players[2]);
            } else if (winPl1 == winPl2 && winPl1 > winPl3) {
                outputDrawWinnerCheck(players[0], players[1]);
            } else if (winPl1 == winPl3 && winPl1 > winPl2) {
                outputDrawWinnerCheck(players[0], players[2]);
            } else if (winPl2 == winPl3 && winPl2 > winPl1) {
                outputDrawWinnerCheck(players[1], players[2]);
            } else {
                System.out.println("По итогам 3 раундов все 3 игрока сыграли в ничью!");
            }
        }
    }

    private boolean attemptsEnded() {
        if (currentPlayerFinished == 3) {
            System.out.println("У всех игроков закончились попытки. Переходите " +
                    "к следующему раунду.");
            outputAllNumsPlayers(players[0].getNums());
            outputAllNumsPlayers(players[1].getNums());
            outputAllNumsPlayers(players[2].getNums());
            return true;
        }
        return false;
    }

    private void outputWinnerCheck(Player player) {
        System.out.println("По итогам 3 раундов победил игрок: " + player);
    }

    private void outputDrawWinnerCheck(Player player1, Player player2) {
        System.out.println("По итогам 3 раундов - 2 игрока сыграли в ничью: " +
                player1 + " и " + player2);
    }
}