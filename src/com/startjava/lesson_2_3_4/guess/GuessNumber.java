package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private static final int MAX_ROUNDS = 3;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_INPUT_NUM = 1;
    private static final int MAX_INPUT_NUM = 100;
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

    private void shuffleQueue(Player[] players) {
        Random rand = new Random();

        for (int i = 0; i < players.length - 1; i++) {
            int j = i + rand.nextInt(players.length - i);
            Player temp = players[i];
            players[i] = players[j];
            players[j] = temp;
        }
    }

    void start() {
        secretNum = (MIN_INPUT_NUM + (int) (Math.random() * MAX_INPUT_NUM));
        init();
        rounds++;

        System.out.println("Игра началась!");
        System.out.println("У каждого игрока по 10 попыток. Всего 3 раунда! Раунд " + rounds);

        boolean isGuessed = false;
        while (!isGuessed && currentPlayerFinished != players.length) {
            if (gameplay()) {
                isGuessed = true;
            }
        }
    }

    private void init() {
        for (Player player : players) {
            player.clear();
        }
        currentPlayerFinished = 0;

        if(rounds == MAX_ROUNDS) {
            rounds = 0;
            for (Player player : players) {
                player.clearScore();
            }
        }
    }

    private boolean gameplay() {
        for (Player player : players) {
            inputNum(player);
            if (checkGuessedNum(player)) {
                for (Player currentPlayer : players) {
                    outputAllNumsPlayers(currentPlayer.getNums());
                }
                player.upScore();
                if (rounds == MAX_ROUNDS) {
                    checkWinner();
                }
                return true;
            }
            checkAttempts(player);
        }
        return false;
    }

    private void inputNum(Player player) {
        Scanner scanner = new Scanner(System.in);
        int enteredNum;
        boolean correctNum;

        do {
            System.out.print("Число угадывает игрок " + player + ": ");
            enteredNum = scanner.nextInt();
            correctNum = true;

            if (!player.addNum(enteredNum)) {
                System.out.println("Введите число 1-100");
                correctNum = false;
            }
        } while (!correctNum);
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

    private void checkAttempts(Player player) {
        if (player.getAmountAttempts() == MAX_ATTEMPTS) {
            System.out.println("у " + player + " закончились попытки");
            currentPlayerFinished++;
        }
        endedAttempts();
    }

    private void outputAllNumsPlayers(int[] numsPlayer1) {
        for (int currentNum : numsPlayer1) {
            System.out.print(currentNum + " ");
        }
        System.out.println();
    }

    private void checkWinner() {
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

    private void endedAttempts() {
        if (currentPlayerFinished == players.length) {
            if (rounds != MAX_ROUNDS) {
                System.out.println("У всех игроков закончились попытки. Переходите " +
                        "к следующему раунду.");
            } else {
                System.out.println("У всех игроков закончились попытки.");
                checkWinner();
            }

            for (Player player : players) {
                outputAllNumsPlayers(player.getNums());
            }
        }
    }
}