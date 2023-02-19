public class Calculator {

    public static void main(String[] args) {
        System.out.println("1. “Калькулятор”:");

        int num = 8;
        int num2 = 4;
        char action = '+';
        int result = 0;

        char plus = '+';
        char minus = '-';
        char multiply = '*';
        char divide = '/';
        char circumflex = '^';
        char percent = '%';

        if (action == plus) {
            result = num + num2;
        } else if (action == minus) {
            result = num - num2;
        } else if (action == multiply) {
            result = num * num2;
        } else if (action == divide) {
            result = num / num2;
        } else if (action == circumflex) {
            result = num;
            for (int i = 1; i < num2; i++) {
                result = result * num;
            }
        } else if (action == percent) {
            result = num % num2;
        }

        System.out.println(num + " " + action+ " " + num2 + " = " + result);

        System.out.println("\n2. Игра “Угадай число”:");

        int numPlayer = 15;
        int numComputer = 22;

        if (numComputer != numPlayer && numPlayer > 0 && numPlayer <= 100) {

            if (numComputer > numPlayer) {
                for (int j = numPlayer; j < numComputer; j++) {
                    System.out.println("Число " + numPlayer + " меньше того, что загадал компьютер");
                    numPlayer++;
                }
                System.out.println("Вы победили!");

            } else if (numComputer < numPlayer) {
                for (int k = numPlayer; k > numComputer; k--) {
                    System.out.println("Число " + numPlayer + " больше того, что загадал компьютер");
                    numPlayer--;
                }
                System.out.println("Вы победили!");
            }

        } else if (numPlayer <= 0 || numPlayer > 100) {
            System.out.println("Введите число 1-100");
        } else {
            System.out.println("Вы победили!");
        }
    }
}