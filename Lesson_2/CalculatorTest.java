import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String answerYesNo;

        do {
            System.out.print("Введите первое число: ");
            calculator.setNum(scanner.nextInt());

            System.out.print("Введите знак математической операции: ");
            calculator.setAction(scanner.next().charAt(0));

            System.out.print("Введите второе число: ");
            calculator.setNum2(scanner.nextInt());

            System.out.println(calculator.calculate());
            scanner.nextLine();

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answerYesNo = scanner.nextLine();
            } while (!answerYesNo.equals("yes") && !answerYesNo.equals("no"));
        } while (!answerYesNo.equals("no"));
    }
}