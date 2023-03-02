import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String answerYesNo;

        System.out.print("Введите имя Первого игрока: ");
        name = scanner.nextLine();

        Player player1 = new Player(name);

        System.out.print("Введите имя Второго игрока: ");
        name = scanner.nextLine();

        Player player2 = new Player(name);
        GuessNumber guessNumber = new GuessNumber();

        do {
            System.out.println("Игра началась!");

            do {
                do {
                    System.out.print("Введите число игрок " + player1.getName() + ": ");
                    int numPlayer1 = scanner.nextInt();
                    player1.setNum(numPlayer1);

                    guessNumber.checkNum(player1.getNum());

                } while (player1.getNum() < 1 || player1.getNum() > 100);

                if (guessNumber.getWinNum() == guessNumber.getComputerNum())
                    break;

                do {
                    System.out.print("Введите число игрок " + player2.getName() + ": ");
                    int numPlayer2 = scanner.nextInt();
                    player2.setNum(numPlayer2);

                    guessNumber.checkNum(player2.getNum());

                } while (player2.getNum() < 1 || player2.getNum() > 100);

            } while (guessNumber.getWinNum() == 0);

            System.out.println("Вы победили!");
            answerYesNo = scanner.nextLine();

            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                answerYesNo = scanner.nextLine();
            } while (answerYesNo.equals("yes") == false && answerYesNo.equals("no") == false);

            guessNumber.setWinNum(0);
            guessNumber.setComputerNum(1 + (int) (Math.random() * 100));

        } while (answerYesNo.equals("no") == false);
    }
}