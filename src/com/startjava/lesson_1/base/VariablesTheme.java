package com.startjava.lesson_1.base;

public class VariablesTheme {

    public static void main(String[] args) {
        System.out.println("1. Вывод значений переменных на консоль:");

        byte diagonal = 15;
        short ram = 16;
        char cpuSeries = 'i';
        long cpuNumber = 7;
        int core = 4;
        float ghz = 3.1f;
        double ssd = 512; 
        boolean work = true;

        System.out.println("Диагональ экрана: " + diagonal + "-inch");
        System.out.println("ОЗУ: " + ram + " гб");
        System.out.println("Процессор: " + cpuSeries + cpuNumber);
        System.out.println("Количество ядер: " + core);
        System.out.println("Количество ГГц: " + ghz);
        System.out.println("SSD: " + ssd + " гб");
        System.out.println("Компьютер работает: " + work);

        System.out.println("\n2. Расчет стоимости товара со скидкой:");

        int pricePen = 100;
        int priceBook = 200;
        int totalSum = pricePen + priceBook;
        int discount = 11;
        int discountSum = totalSum * discount / 100;
        int discountPrice = totalSum - discountSum;

        System.out.println("Общая стоимость товаров без скидки: " + totalSum + " руб.");
        System.out.println("Сумма скидки: " + discount + "%");
        System.out.println("Общая стоимость товаров со скидкой: " + discountPrice + " руб.");

        System.out.println("\n3. Вывод слова JAVA:");
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a ");

        System.out.println("\n4. Вывод min и max значений целых числовых типов:");

        byte byteMax = 127;
        short shortMax = 32767;
        int intMax = 2147483647;
        long maxLong = 9223372036854775807l;

        System.out.println("byte: " + byteMax);
        System.out.println(++byteMax + "\n" + --byteMax);

        System.out.println("short: " + shortMax);
        System.out.println(++shortMax + "\n" + --shortMax);

        System.out.println("int: " + intMax);
        System.out.println(++intMax + "\n" + --intMax);

        System.out.println("long: " + maxLong);
        System.out.println(++maxLong + "\n" + --maxLong);

        System.out.println("\n5. Перестановка значений переменных:");

        int num = 2;
        int num1 = 5;
        int temp = num;

        System.out.println("С помощью третьей переменной:");
        System.out.println(num + "," + num1);
        num = num1;
        num1 = temp;
        System.out.println(num + "," + num1);

        System.out.println("С помощью арифметических операций:");
        System.out.println(num + "," + num1);
        num += num1;
        num1 = num - num1;
        num -= num1;
        System.out.println(num + "," + num1);

        System.out.println("С помощью побитовой операции ^:");
        System.out.println(num + "," + num1);
        num ^= num1;
        num1 ^= num;
        num ^= num1;
        System.out.println(num + "," + num1);

        System.out.println("\n6. Вывод символов и их кодов:");

        char hash = '#';
        char and = '&';
        char at = '@';
        char circumflex = '^';
        char underscope = '_';

        System.out.println((int) hash + ": " + hash);
        System.out.println((int) and + ": " + and);
        System.out.println((int) at + ": " + at);
        System.out.println((int) circumflex + ": " + circumflex);
        System.out.println((int) underscope + ": " + underscope);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка:");

        char slash = '/';
        char backSlash = '\\';
        char underline = '_';
        char parenthesisRight = '(';
        char parenthesisLeft = ')';

        System.out.println("    " + slash + backSlash);
        System.out.println("   " + slash + "  " + backSlash);
        System.out.println("  " + slash + underline + parenthesisRight + " " + slash + backSlash);
        System.out.println(" " + slash + "      " + backSlash);
        System.out.print("" + slash + underline + underline + underline + underline);
        System.out.println("" + slash + backSlash + underline + underline + backSlash);

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа:");

        int srcNum = 123;
        int hundred = srcNum / 100;
        int tens = srcNum % 100 / 10;
        int ones = srcNum % 10;
        int sum = hundred + tens + ones;
        int multiply = hundred * tens * ones;

        System.out.println("Число 123 содержит:");
        System.out.println("сотен: " + hundred);
        System.out.println("десятков: " + tens);
        System.out.println("единиц: " + ones);
        System.out.println("Сумма его цифр: " + sum);
        System.out.println("Произведение цифр: " + multiply);

        System.out.println("\n9. Вывод времени (кол-во секунд 86399):");

        int allSeconds = 86399; 
        int hours = allSeconds / 3600;
        int minutes = allSeconds / 60 % 60;
        int seconds = allSeconds % 60;

        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}