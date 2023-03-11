import java.util.Scanner;

public class GuessNumber {

    private int computerNum;
    private int numPlayer;
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void start() {
        computerNum = (1 + (int) (Math.random() * 100));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Игра началась!");

        do {
            do {
                System.out.print("Число угадывает игрок " + player1 + ": ");
                numPlayer = scanner.nextInt();

                if (checkNumCorrect()) {
                    System.out.println("Введите число 1-100");
                }
            } while (checkNumCorrect());

            if (checkNumWin())
                break;

            do {
                System.out.print("Число угадывает игрок " + player2 + ": ");
                numPlayer = scanner.nextInt();

                if (checkNumCorrect()) {
                    System.out.println("Введите число 1-100");
                }
            } while (checkNumCorrect());
        } while (!checkNumWin());
    }

    private boolean checkNumCorrect() {
        boolean checkNumCorrect = numPlayer < 1 || numPlayer > 100;
        return checkNumCorrect;
    }

    private boolean checkNumWin() {
        if (numPlayer != computerNum) {
            if (numPlayer < computerNum) {
                System.out.println("Число " + numPlayer + " меньше того, что загадал компьютер");
            } else if (numPlayer > computerNum) {
                System.out.println("Число " + numPlayer + " больше того, что загадал компьютер");
            }
        return false;
        } else {
            System.out.println("Вы победили!");
        return true;
        }
    }
}