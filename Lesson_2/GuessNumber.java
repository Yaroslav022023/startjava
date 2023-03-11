import java.util.Scanner;

public class GuessNumber {

    private int secretNum;
    private int numPlayer;
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void start() {
        secretNum = (1 + (int) (Math.random() * 100));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Игра началась!");

        do {
            do {
                System.out.print("Число угадывает игрок " + player1 + ": ");
                player1.setNumPlayer(scanner.nextInt());
                numPlayer = player1.getNumPlayer();

                if (isValidNum()) {
                    System.out.println("Введите число 1-100");
                }
            } while (isValidNum());

            if (isGuessed())
                break;

            do {
                System.out.print("Число угадывает игрок " + player2 + ": ");
                player2.setNumPlayer(scanner.nextInt());
                numPlayer = player2.getNumPlayer();

                if (isValidNum()) {
                    System.out.println("Введите число 1-100");
                }
            } while (isValidNum());
        } while (!isGuessed());
    }

    private boolean isValidNum() {
        return numPlayer < 1 || numPlayer > 100;
    }

    private boolean isGuessed() {
        if (numPlayer < secretNum) {
            System.out.println("Число " + numPlayer + " меньше того, что загадал компьютер");
            return false;
        } else if (numPlayer > secretNum) {
            System.out.println("Число " + numPlayer + " больше того, что загадал компьютер");
            return false;
        } else {
            System.out.println("Вы победили!");
            return true;
        }
    }
}