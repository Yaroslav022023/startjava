import java.util.Scanner;

public class GuessNumber {

    private int computerNum = 1 + (int) (Math.random() * 100);
    private int winNum = 0;
    private int numPlayer;
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getWinNum() {
        return winNum;
    }

    void setWinNum(int winNum) {
        this.winNum = winNum;
    }

    public int getComputerNum() {
        return computerNum;
    }

    void setComputerNum(int computerNum) {
        this.computerNum = computerNum;
    }

    Scanner scanner = new Scanner(System.in);

    void start() {
        System.out.println("Игра началась!");

        do {
            do {
                System.out.print("Число угадывает игрок " + player1.toString() + ": ");
                numPlayer = scanner.nextInt();

                if (numPlayer < 1 || numPlayer > 100) {
                    System.out.println("Введите число 1-100");
                }
            } while (numPlayer < 1 || numPlayer > 100);

            checkNum();

            if (winNum == computerNum)
                break;

            do {
                System.out.print("Число угадывает игрок " + player2.toString() + ": ");
                numPlayer = scanner.nextInt();

                if (numPlayer < 1 || numPlayer > 100) {
                    System.out.println("Введите число 1-100");
                }
            } while (numPlayer < 1 || numPlayer > 100);

            checkNum();
        } while (winNum == 0);

        setWinNum(0);
        setComputerNum(1 + (int) (Math.random() * 100));
    }

    void checkNum() {
        if (numPlayer != computerNum) {
            if (numPlayer < computerNum && numPlayer > 0) {
                System.out.println("Число " + numPlayer + " меньше того, что загадал компьютер");
            } else if (numPlayer > computerNum && numPlayer <= 100) {
                System.out.println("Число " + numPlayer + " больше того, что загадал компьютер");
            }
        } else {
            winNum = computerNum;
            System.out.println("Вы победили!");
        }
    }
}