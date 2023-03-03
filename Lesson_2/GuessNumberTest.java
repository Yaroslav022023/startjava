import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answerYesNo;

        System.out.print("Введите имя Первого игрока: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Введите имя Второго игрока: ");
        Player player2 = new Player(scanner.nextLine());

        GuessNumber guessNumber = new GuessNumber();

        do {
            System.out.println("Игра началась!");

            do {
                do {
                    System.out.print("Введите число игрок " + player1.getName() + ": ");
                    player1.setNum(scanner.nextInt());
                    guessNumber.checkNum(player1.getNum());
                } while (player1.getNum() < 1 || player1.getNum() > 100);

                if (guessNumber.getWinNum() == guessNumber.getComputerNum())
                    break;

                do {
                    System.out.print("Введите число игрок " + player2.getName() + ": ");
                    player2.setNum(scanner.nextInt());
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
            player1.setNum0(0);
            player2.setNum0(0);

        } while (answerYesNo.equals("no") == false);
    }
}