package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    static final int START_RANGE = 1;
    static final int END_RANGE = 100;
    private static final int MAX_ROUNDS = 3;
    private static final int MAX_ATTEMPTS = 10;
    private final Player[] players;
    private int secretNum;
    private int currentRound;
    private boolean guessed;

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
        while (currentRound != MAX_ROUNDS) {
            secretNum = (START_RANGE + (int) (Math.random() * END_RANGE));
            init();
            currentRound++;

            System.out.println("\nРаунд " + currentRound + ":");

            while (!checkEndRounds()) {
                if (launchGameplay()) {
                    guessed = true;
                }
            }
            outputAllNumsPlayers();
        }
        defineWinner();
        init();
    }

    private void init() {
        for (Player player : players) {
            player.clear();
        }
        guessed = false;

        if(currentRound == MAX_ROUNDS) {
            currentRound = 0;
            for (Player player : players) {
                player.clearScore();
            }
        }
    }

    private boolean checkEndRounds() {
        return guessed || players[players.length - 1].getAmountAttempts() == MAX_ATTEMPTS;
    }

    private boolean launchGameplay() {
        for (Player player : players) {
            inputNum(player);
            if (isGuessed(player)) {
                return true;
            }
            checkAttempts(player);
        }
        return false;
    }

    private void inputNum(Player player) {
        Scanner scanner = new Scanner(System.in);
        int enteredNum = 0;

        do {
            System.out.print("Число угадывает игрок " + player + ": ");
            try {
                enteredNum = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("Вы ввели не число :)");
                scanner.nextLine();
            }
        } while (!player.addNum(enteredNum));
    }

    private boolean isGuessed(Player player) {
        int lastNumPlayer = player.getLastNum();

        if (lastNumPlayer == secretNum) {
            System.out.println("Игрок " + player + " угадал число " + lastNumPlayer +
                    " c " + player.getAmountAttempts() + " попытки");
            player.upScore();
            return true;
        }
        System.out.println("Число " + lastNumPlayer + (lastNumPlayer < secretNum ?
                " меньше" : " больше") + " того, что загадал компьютер");
        return false;
    }

    private void checkAttempts(Player player) {
        if (player.getAmountAttempts() == MAX_ATTEMPTS) {
            System.out.println("у " + player + " закончились попытки");
        }
        endedAttempts();
    }

    private void endedAttempts() {
        if (players[players.length - 1].getAmountAttempts() == MAX_ATTEMPTS) {
            if (currentRound != MAX_ROUNDS) {
                System.out.println("У всех игроков закончились попытки. Переходите " +
                        "к следующему раунду.");
            } else {
                System.out.println("У всех игроков закончились попытки");
            }
        }
    }

    private void outputAllNumsPlayers() {
        for (Player player : players) {
            System.out.print(player + ": ");
            for (int currentNum : player.getNums()) {
                System.out.print(currentNum + " ");
            }
            System.out.println();
        }
    }

    private void defineWinner() {
        if (currentRound == MAX_ROUNDS) {
            int indexWinner = 0;
            int draw = 1;
            int winner = players[indexWinner].getScore();

            for (int i = 1; i < players.length; i++) {
                if (players[i].getScore() > winner) {
                    indexWinner = i;
                } else if (winner == players[i].getScore()) {
                    draw++;
                }
            }

            if (draw == 1 || indexWinner > 0) {
                System.out.println("\nПо итогам 3 раундов победил игрок: " + players[indexWinner]);
            } else {
                System.out.printf("\nПо итогам 3 раундов - %d игрока сыграли в ничью.\n", draw);
            }
        }
    }
}