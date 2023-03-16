package com.startjava.lesson_1.finished;

public class GuessNumber {

    public static void main(String[] args) {
        System.out.println("2. Игра “Угадай число”:");

        int playerNum = 15;
        int computerNum = 22;

        if (computerNum != playerNum && playerNum > 0 && playerNum <= 100) {
            if (playerNum < computerNum) {
                for (int i = playerNum; i < computerNum; i++) {
                    System.out.println("Число " + playerNum + " меньше того, что загадал компьютер");
                    playerNum++;
                }

            } else if (playerNum > computerNum) {
                for (int i = playerNum; i > computerNum; i--) {
                    System.out.println("Число " + playerNum + " больше того, что загадал компьютер");
                    playerNum--;
                }
            }
            System.out.println("Вы победили!");

        } else if (playerNum <= 0 || playerNum > 100) {
            System.out.println("Введите число 1-100");
        } else {
            System.out.println("Вы победили с первого раза!");
        }
    }
}