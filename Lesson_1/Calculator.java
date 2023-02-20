public class Calculator {

    public static void main(String[] args) {
        System.out.println("1. Калькулятор:");

        int num = 8;
        int num2 = 4;
        char action = '+';
        int result = 0;

        if (action == '+') {
            result = num + num2;
        } else if (action == '-') {
            result = num - num2;
        } else if (action == '*') {
            result = num * num2;
        } else if (action == '/') {
            result = num / num2;
        } else if (action == '^') {
            result = num;
            for (int i = 1; i < num2; i++) {
                result *= num;
            }
        } else if (action == '%') {
            result = num % num2;
        }

        System.out.println(num + " " + action + " " + num2 + " = " + result);
    }
}