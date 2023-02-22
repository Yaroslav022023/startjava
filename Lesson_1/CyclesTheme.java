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

        int min = 5;
        int mid = 10;
        int max = -1;
        int temp = 0;

        if (min > mid) {
            temp = mid;
            mid = min;
            min = temp;
        }

        if (mid > max) {
            temp = max;
            max = mid;
            mid = temp;
        }

        if (min > mid) {
            temp = mid;
            mid = min;
            min = temp;
        }

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр:");

        int reverseNumber = 1234;
        int sumDigits = 0;

        while (reverseNumber != 0) {
            int ones = reverseNumber % 10;
            sumDigits += ones;
            System.out.print(ones);
            reverseNumber /= 10;
        }
        System.out.println("\n" + sumDigits);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк:");

        int amountLines = 0;

        for (int i = 1; i < 24; i += 2) {
            System.out.printf("%3d", i);
            amountLines++;

            if (amountLines % 5 == 0) {
                System.out.println();
            }
        }

        while (amountLines % 5 != 0) {
            System.out.printf("%3d", 0);
            amountLines++;
        }

        System.out.println("\n\n5. Проверка количества двоек на четность/нечетность:");

        int num = 3242592;
        int copyNum = num;
        int countTwos = 0;

        while (copyNum > 0) {
            if (copyNum % 10 == 2) {
                countTwos++;
            }
            copyNum /= 10;
        }

        if (countTwos % 2 == 0) {
            System.out.println("число " + num + " содержит " + countTwos 
                    + " (четное) количество двоек.");
        } else {
            System.out.println("число " + num + " содержит " + countTwos 
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
        int hashSymbols = 5;
        int amountHashSymbols = 5;

        while (lines > 0) {
            while (hashSymbols > 0) {
                System.out.print('#');
                hashSymbols--;
            }
            System.out.println();
            lines--;
            hashSymbols = amountHashSymbols - 1;
            amountHashSymbols--;
        }

        System.out.println();

        lines = 5;
        int dollarSymbols = 1;

        do {
            do {
                System.out.print('$');
                dollarSymbols--; 
            } while (dollarSymbols > 0);

            System.out.println();
            lines--;

            if (lines == 4 || lines == 2) {
                dollarSymbols += 2;
            } else if (lines == 3) {
                dollarSymbols += 3;
            } else {
                dollarSymbols += 1;
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

        int sumRight3 = 0;
        int sumLeft3 = 0;
        int amountDigits = 0;

        while (amountDigits < 6) {
            if (amountDigits < 3) {
                sumRight3 += copyLuckyNum % 10;
                copyLuckyNum /= 10;
                amountDigits++;
            } else {
                sumLeft3 += copyLuckyNum % 10;
                copyLuckyNum /= 10;
                amountDigits++;
            }
        }

        if (sumRight3 == sumLeft3) {
            System.out.println("Сумма первых трех цифр = " + sumLeft3 + "\n" 
                    + "Сумма последних трех цифр = " + sumRight3 + "\n" + "Число " + luckyNum 
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