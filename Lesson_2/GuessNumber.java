import java.util.Scanner;

public class GuessNumber {

    private int secretNum;
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
                player1.setNum(scanner.nextInt());
            } while (isValidNum(player1.getNum()));

            if (isGuessed(player1.getNum()))
                break;

            do {
                System.out.print("Число угадывает игрок " + player2 + ": ");
                player2.setNum(scanner.nextInt());
            } while (isValidNum(player2.getNum()));
        } while (!isGuessed(player2.getNum()));
    }

    private boolean isValidNum(int numPlayer) {
        if (numPlayer < 1 || numPlayer > 100) {
            System.out.println("Введите число 1-100");
            return true;
        }
        return false;
    }

    private boolean isGuessed(int numPlayer) {
        if (numPlayer < secretNum) {
            System.out.println("Число " + numPlayer + " меньше того, что загадал компьютер");
        } else if (numPlayer > secretNum) {
            System.out.println("Число " + numPlayer + " больше того, что загадал компьютер");
        } else {
            System.out.println("Вы победили!");
            return true;
        }
        return false;
    }
}