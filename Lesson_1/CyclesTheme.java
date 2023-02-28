public class CyclesTheme {

    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел:");

        int counter = -10;
        int sumEven = 0;
        int sumOdd = 0;

        do {
            if (counter % 2 == 0) {
                sumEven += counter;
            } else {
                sumOdd += counter;
            }
            counter++;
        } while (counter <= 21);
        System.out.println("В промежутке [-10, 21] сумма четных чисел = " +  sumEven +  " а нечетных = "
                + sumOdd);

        System.out.println("\n2. Вывод чисел в интервале (min и max) в порядке убывания:");

        int num1 = -1;
        int num2 = 10;
        int num3 = 5;
        int min = num1;
        int max = num2;

        if (num1 > max) {
            max = num1;
        } 
        if (num3 > max) {
            max = num3;
        }
        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            min = num3;
        }

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр:");

        int num4 = 1234;
        int sumRemainders = 0;

        while (num4 > 0) {
            int remainder = num4 % 10;
            sumRemainders += remainder;
            System.out.print(remainder);
            num4 /= 10;
        }
        System.out.println("\n" + sumRemainders);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк:");

        int amountDigitsInLine = 0;

        for (int i = 1; i < 24; i += 2) {
            System.out.printf("%3d", i);
            amountDigitsInLine++;

            if (amountDigitsInLine % 5 == 0) {
                System.out.println();
            }
        }

        while (amountDigitsInLine % 5 != 0) {
            System.out.printf("%3d", 0);
            amountDigitsInLine++;
        }

        System.out.println("\n\n5. Проверка количества двоек на четность/нечетность:");

        int num5 = 3242592;
        int copyNum = num5;
        int countTwos = 0;

        while (copyNum > 0) {
            if (copyNum % 10 == 2) {
                countTwos++;
            }
            copyNum /= 10;
        }

        if (countTwos % 2 == 0) {
            System.out.println("число " + num5 + " содержит " + countTwos 
                    + " (четное) количество двоек.");
        } else {
            System.out.println("число " + num5 + " содержит " + countTwos 
                    + " (нечетное) количество двоек.");
        }

        System.out.println("\n6. Отображение фигур в консоли:");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();

        int lines = 5;
        int amountSymbolsInLine = 5;

        while (lines > 0) {
            while (amountSymbolsInLine > 0) {
                System.out.print('#');
                amountSymbolsInLine--;
            }
            System.out.println();
            lines--;
            amountSymbolsInLine = lines;
        }

        System.out.println();

        lines = 5;
        amountSymbolsInLine = 1;

        do {
            do {
                System.out.print('$');
                amountSymbolsInLine--; 
            } while (amountSymbolsInLine > 0);

            System.out.println();
            lines--;

            if (lines == 4 || lines == 2) {
                amountSymbolsInLine += 2;
            } else if (lines == 3) {
                amountSymbolsInLine += 3;
            } else {
                amountSymbolsInLine += 1;
            }
        } while (lines > 0);

        System.out.println("\n7. Отображение ASCII-символов:");

        System.out.println("Dec " + " Char");

        for (int i = 1; i <= 122; i++) {
            if (i <= 47 && i % 2 != 0) {
                System.out.printf("%3d %3s%n", i, (char) i);
            } else if (i >= 98 && i <= 122 && i % 2 == 0) {
                System.out.printf("%3d %3s%n", i, (char) i);
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом:");

        int palindromeNum = 1234321;
        int copyPalindromeNum = palindromeNum;
        int reverseNum = 0;

        while (copyPalindromeNum > 0) {
            reverseNum = reverseNum * 10 + copyPalindromeNum % 10;
            copyPalindromeNum /= 10;
        }
        if (palindromeNum == reverseNum) {
            System.out.println("Число " + palindromeNum + " является палиндромом.");
        } else {
            System.out.println("Число " + palindromeNum + " не является палиндромом.");
        }

        System.out.println("\n9. Определение, является ли число счастливым:");

        int luckyNum = 423135;
        int copyLuckyNum = luckyNum;

        int sumRightHalf = 0;
        int sumLeftHalf = 0;
        int amountDigits = 0;

        while (amountDigits < 6) {
            if (amountDigits < 3) {
                sumRightHalf += copyLuckyNum % 10;
            } else {
                sumLeftHalf += copyLuckyNum % 10;
            }
            copyLuckyNum /= 10;
            amountDigits++;
        }

        if (sumRightHalf == sumLeftHalf) {
            System.out.println("Сумма первых трех цифр = " + sumLeftHalf + "\n" 
                    + "Сумма последних трех цифр = " + sumRightHalf + "\n" + "Число " + luckyNum 
                    + " - является счастливым.");
        } else {
            System.out.println("Число " + luckyNum + " - не является счастливым.");
        }

        System.out.println("\n10. Вывод таблицы умножения Пифагора:");

        for (int i = 1; i <= 9; i++) {
            if (i == 1) {
                System.out.printf("%5s", "│");
            } else {
                System.out.printf("%3d %1s", i, "│");
            }

            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }

            if (i == 1) {
                System.out.println();
                for (int j = 0; j <= 13; j++) {
                    System.out.print("——");
                        if (j == 1) {
                            System.out.print("│");
                        }
                }
            }
            System.out.println();
        }
    }
}