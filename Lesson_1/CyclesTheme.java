public class CyclesTheme {

    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел:");

        int i = -10;
        int sum = 0;
        int sumEven = 0;
        int sumOdd = 0;

        do {
            sum = i;
            if (sum % 2 == 0) {
                sumEven += sum;
            } else {
                sumOdd += sum;
            }
            i++;
        } while (i <= 21);
        System.out.println("В промежутке [-10, 21] сумма четных чисел = " +  sumEven +  " а нечетных = "
                + sumOdd);

        System.out.println("\n2. Вывод чисел в интервале (min и max) в порядке убывания:");

        int num = -1;
        int num1 = 5;
        int num2 = 10;

        int min = 0;
        int max = 0;

        if (num > num1 && num > num2) {
            max = num;
        } else if (num < num1 && num < num2) {
            min = num;
        }

        if (num1 > num && num1 > num2) {
            max = num1;
        } else if (num1 < num && num1 < num2) {
            min = num1;
        }

        if (num2 > num && num2 > num1) {
            max = num2;
        } else if (num2 < num && num2 < num1) {
            min = num2;
        }

        for (int j = 0; j < 1; j++) {
            if (max > num && num > min) {
                System.out.println(max + " " + num + " " + min);
            } else if (max > num1 && num1 > min) {
                System.out.println(max + " " + num1 + " " + min);
            } else if (max > num2 && num2 > min) {
                System.out.println(max + " " + num2 + " " + min);
            }
        }

        System.out.println("\n3. Вывод реверсивного числа и суммы его цифр:");

        int number = 1234;
        int revers = 0;
        int sumNumbers = 0;

        while (number != 0) {
            sumNumbers = sumNumbers + number % 10;
            revers = revers * 10 + (number % 10);
            number /= 10;
        }
        System.out.println(revers);
        System.out.println(sumNumbers);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк:");

        int memoryCycle = 0;

        for (int k = 1; k < 24; k += 2) {
            System.out.printf("%3d", k);
            memoryCycle++;

            if (memoryCycle % 5 == 0) {
                System.out.print("\n");
            }
        }

        while (memoryCycle % 5 != 0) {
            System.out.printf("%3d", 0);
            memoryCycle++;
        }

        System.out.println("\n\n5. Проверка количества двоек на четность/нечетность:");

        int x = 3242592;
        int amount2 = 0;

        while (x > 0) {
            if (x % 10 == 2) {
                amount2++;
            }
            x /= 10;
        }

        if (amount2 % 2 == 0) {
            System.out.println("число " + 3242592 + " содержит " + amount2 
                    + " (четное) количество двоек.");
        } else if (amount2 % 2 != 0 ) {
            System.out.println("число " + 3242592 + " содержит " + amount2 
                    + " (нечетное) количество двоек.");
        }

        System.out.println("\n6. Отображение фигур в консоли:");

        char asterisk = '*';
        char hash = '#';
        char dollar = '$';

        for (int w = 0; w < 5; w++) {
            for (int e = 0; e < 10; e++) {
                System.out.print(asterisk);
            }
            System.out.println("");
        }

        System.out.println("");
        int externalLimit = 5;
        int insideLimit = 5;
        int cycles = 5;

        while (externalLimit > 0) {
            while (insideLimit > 0) {
                System.out.print(hash);
                insideLimit--;
            }
            System.out.println("");
            externalLimit--;
            insideLimit = cycles - 1;
            cycles--;
        }

        System.out.println("");
        int externalLimit2 = 5;
        int insideLimit2 = 1;

        do {
            do {
                System.out.print(dollar);
                insideLimit2--; 
            } while (insideLimit2 > 0);

            System.out.println("");
            externalLimit2--;

            if (externalLimit2 == 4 || externalLimit2 == 2) {
                insideLimit2 += 2;
            } else if (externalLimit2 == 3) {
                insideLimit2 += 3;
            } else {
                insideLimit2 += 1;
            }
        } while (externalLimit2 > 0);

        System.out.println("\n7. Отображение ASCII-символов:");

        System.out.println("Dec " + " Char");

        for (int m = 1; m <= 122; m++) {

            if (m % 2 != 0 && m <= 47) {
            char ch = (char) m;
            System.out.printf("%3d %3s%n", m, ch);

            } else if (m % 2 == 0 && m >= 98 && m <= 122) {
                char chh = (char) m;
                System.out.printf("%3d %3s%n", m, chh);
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
        int numRevers = 0;

        int sumLast3 = 0;
        int sumFirst3 = 0;
        int memoryCycl = 0;

        while (memoryCycl != 3) {
            sumLast3 += num5 % 10;
            num5 /= 10;
            memoryCycl++;
        }

        while (num5 != 0 ) {
            numRevers = numRevers * 10 + num5 % 10;
            num5 /= 10;
        }

        while (memoryCycl != 6) {
            sumFirst3 += numRevers % 10;
            numRevers /= 10;
            memoryCycl++;
        }

        if (sumLast3 == sumFirst3) {
            System.out.println("Сумма первых трех цифр = " + sumFirst3 + "\n" 
                    + "Сумма последних трех цифр = " + sumLast3 + "\n" + "Число " + num4 
                            + " - является счастливым.");
        } else {
            System.out.println("Число " + num4 + " - не является счастливым.");
        }

        System.out.println("\n10. Вывод таблицы умножения Пифагора:");

        for (int f = 1; f <= 9; f++) {
            if (f == 1) {
                System.out.printf("%5s", "│");
            } else {
                System.out.printf("%3d %1s", f, "│");
            }

            for (int g = 2; g <= 9; g++) {
                System.out.printf("%3d", f * g);
            }

            if (f == 1) {
                System.out.println("");
                for (int q = 0; q <= 13; q++) {
                    System.out.print("——");
                        if (q == 1) {
                            System.out.print("│");
                        }
                }
            }
            System.out.println("");
        }
    }
}