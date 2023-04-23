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
        secretNum = (START_RANGE + (int) (Math.random() * END_RANGE));
        init();
        currentRound++;

        System.out.println("Игра началась!");
        System.out.println("У каждого игрока по 10 попыток. Всего 3 раунда! Раунд " + currentRound);

        boolean isGuessed = false;
        while (!isGuessed && players[players.length - 1].getAmountAttempts() != MAX_ATTEMPTS) {
            if (launchGameplay()) {
                isGuessed = true;
            }
        }
        for (Player player : players) {
            outputAllNumsPlayers(player);
        }
    }

    private void init() {
        for (Player player : players) {
            player.clear();
        }
        currentPlayerFinished = 0;

        if(currentRound == MAX_ROUNDS) {
            currentRound = 0;
            for (Player player : players) {
                player.clearScore();
            }
        }
    }

    private boolean launchGameplay() {
        for (Player player : players) {
            inputNum(player);
            if (checkGuessedNum(player)) {
                player.upScore();
                if (currentRound == MAX_ROUNDS) {
                    defineWinner();
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

        do {
            System.out.print("Число угадывает игрок " + player + ": ");
            enteredNum = scanner.nextInt();
        } while (!player.addNum(enteredNum));
    }

    private boolean checkGuessedNum(Player player) {
        int lastNumPlayer = player.getLastNum();

        if (lastNumPlayer == secretNum) {
            System.out.println("Игрок " + player + " угадал число " + lastNumPlayer +
                    " c " + player.getAmountAttempts() + " попытки");
            return true;
        }
        System.out.println("Число " + lastNumPlayer + (lastNumPlayer < secretNum ?
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

    private void outputAllNumsPlayers(Player player) {
        System.out.print(player + ": ");
        for (int currentNum : player.getNums()) {
            System.out.print(currentNum + " ");
        }
        System.out.println();
    }

    private void defineWinner() {
        int indexOfWinner = 0;
        int draw = 1;

        for (int i = 1; i < players.length; i++) {
            if (players[i].getScore() > players[indexOfWinner].getScore()) {
                indexOfWinner = i;
            } else if (players[indexOfWinner].getScore() == players[i].getScore()) {
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
            if (currentRound != MAX_ROUNDS) {
                System.out.println("У всех игроков закончились попытки. Переходите " +
                        "к следующему раунду.");
            } else {
                System.out.println("У всех игроков закончились попытки.");
                defineWinner();
            }
        }
    }
}