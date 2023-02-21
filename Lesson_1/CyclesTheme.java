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
        int num = 10; 
        int max = -1; 
        int memoryDigit = 0;

        if (min > num) {
            memoryDigit = num;
            num = min;
            min = memoryDigit;
        }

        if (num > max) {
            memoryDigit = max;
            max = num;
            num = memoryDigit;
        }

        if (min > num) {
            memoryDigit = num;
            num = min;
            min = memoryDigit;
        }

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n3. Вывод реверсивного числа и суммы его цифр:");

        int num6 = 1234;
        int sumDigits = 0;

        while (num6 != 0) {
            sumDigits = sumDigits + num6 % 10;
            System.out.print(num6 % 10);
            num6 /= 10;
        }
        System.out.println("\n" + sumDigits);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк:");

        int amountCycles = 0;

        for (int i = 1; i < 24; i += 2) {
            System.out.printf("%3d", i);
            amountCycles++;

            if (amountCycles % 5 == 0) {
                System.out.println();
            }
        }

        while (amountCycles % 5 != 0) {
            System.out.printf("%3d", 0);
            amountCycles++;
        }

        System.out.println("\n\n5. Проверка количества двоек на четность/нечетность:");

        int num7 = 3242592;
        int countTwos = 0;

        while (num7 > 0) {
            if (num7 % 10 == 2) {
                countTwos++;
            }
            num7 /= 10;
        }

        if (countTwos % 2 == 0) {
            System.out.println("число " + 3242592 + " содержит " + countTwos 
                    + " (четное) количество двоек.");
        } else if (countTwos % 2 != 0 ) {
            System.out.println("число " + 3242592 + " содержит " + countTwos 
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
        int symbols = 5;
        int reducingSymbols = 5;

        while (lines > 0) {
            while (symbols > 0) {
                System.out.print('#');
                symbols--;
            }
            System.out.println();
            lines--;
            symbols = reducingSymbols - 1;
            reducingSymbols--;
        }

        System.out.println();

        int line = 5;
        int amountSymbols = 1;

        do {
            do {
                System.out.print('$');
                amountSymbols--; 
            } while (amountSymbols > 0);

            System.out.println();
            line--;

            if (line == 4 || line == 2) {
                amountSymbols += 2;
            } else if (line == 3) {
                amountSymbols += 3;
            } else {
                amountSymbols += 1;
            }
        } while (line > 0);

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

        int num3 = 1234321;
        int numOld = num3;
        int numNew = 0;

        while (numOld != 0) {
            numNew = numNew * 10 + numOld % 10;
            numOld /= 10;
        }
        if (num3 == numNew) {
            System.out.println("Число " + num3 + " является палиндромом.");
        } else {
            System.out.println("Число " + num3 + " не является палиндромом.");
        }

        System.out.println("\n9. Определение, является ли число счастливым:");

        int num4 = 4236135;
        int num5 = num4; 
        int num5Revers = 0;

        int sumLast3 = 0;
        int sumFirst3 = 0;
        int amountCycle = 0;

        while (amountCycle != 3) {
            sumLast3 += num5 % 10;
            num5 /= 10;
            amountCycle++;
        }

        while (num5 != 0 ) {
            num5Revers = num5Revers * 10 + num5 % 10;
            num5 /= 10;
        }

        while (amountCycle != 6) {
            sumFirst3 += num5Revers % 10;
            num5Revers /= 10;
            amountCycle++;
        }

        if (sumLast3 == sumFirst3) {
            System.out.println("Сумма первых трех цифр = " + sumFirst3 + "\n" 
                    + "Сумма последних трех цифр = " + sumLast3 + "\n" + "Число " + num4 
                            + " - является счастливым.");
        } else {
            System.out.println("Число " + num4 + " - не является счастливым.");
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