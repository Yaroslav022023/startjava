public class VariablesTheme {

    public static void main(String[] args) {
        System.out.println("1. Вывод значений переменных на консоль:");

        byte diagonal = 15;
        short ram = 16;
        char processorSeries = 'i';
        long processorNumber = 7;
        int core = 4;
        float ghz = 3.1f;
        double ssd = 512; 
        boolean work = true;

        System.out.println("Диагональ экрана: " + diagonal + "-inch");
        System.out.println("ОЗУ: " + ram + " гб");
        System.out.println("Процессор: " + processorSeries + processorNumber);
        System.out.println("Количество ядер: " + core);
        System.out.println("Количество ГГц: " + ghz);
        System.out.println("SSD: " + ssd + " гб");
        System.out.println("Компьютер работает: " + work);

        System.out.println("\n2. Расчет стоимости товара со скидкой:");

        int pricePen = 100;
        int priceBook = 200;
        int priceSum = pricePen + priceBook;
        int sale = 11;
        int discount = priceSum * sale / 100;
        int result = priceSum - discount;

        System.out.println("Общая стоимость товаров без скидки: " + priceSum + " руб.");
        System.out.println("Сумма скидки: " + sale + "%");
        System.out.println("Общая стоимость товаров со скидкой: " + result + " руб. \n");

        System.out.println("3. Вывод слова JAVA:");
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
        byteMax++;
        System.out.println(byteMax);
        byteMax--;
        System.out.println(byteMax);

        System.out.println("short: " + shortMax);
        shortMax++;
        System.out.println(shortMax);
        shortMax--;
        System.out.println(shortMax);

        System.out.println("int: " + intMax);
        intMax++;
        System.out.println(intMax);
        intMax--;
        System.out.println(intMax);

        System.out.println("long: " + maxLong);
        maxLong++;
        System.out.println(maxLong);
        maxLong--;
        System.out.println(maxLong);

        System.out.println("\n5. Перестановка значений переменных:");

        int num = 2;
        int num1 = 5;
        int temp; 

        System.out.println("С помощью третьей переменной:");
        System.out.println(num + "," + num1);
        temp = num;
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

        int digit = 35;
        int digit1 = 38;
        int digit2 = 64;
        int digit3 = 94;
        int digit4 = 95;

        char charDigit = '#';
        char charDigit1 = '&';
        char charDigit2 = '@';
        char charDigit3 = '^';
        char charDigit4 = '_';

        System.out.println(digit + ": " + charDigit);
        System.out.println(digit1 + ": " + charDigit1);
        System.out.println(digit2 + ": " + charDigit2);
        System.out.println(digit3 + ": " + charDigit3);
        System.out.println(digit4 + ": " + charDigit4);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка:");

        char forwardSlash = '/';
        char backSlash = '\\';
        char underline = '_';
        char parenthesisRight = '(';
        char parenthesisLeft = ')';

        System.out.println("    " + forwardSlash + backSlash + "     ");
        System.out.println("   " + forwardSlash + "  " + backSlash + "    ");
        System.out.print("  " + forwardSlash + underline + parenthesisRight + " ");
        System.out.println("" + parenthesisLeft + backSlash + "   ");
        System.out.println(" " + forwardSlash + "      " + backSlash + "  ");
        System.out.print("" + forwardSlash + underline + underline + underline + underline);
        System.out.println("" + forwardSlash + backSlash + underline + underline + backSlash + " ");

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа:");

        int digital = 123;
        int hundred = digital / 100;
        int dozens = digital / 10;
        int singe = digital / 1;
        int sum = hundred + dozens + singe;
        int multiply = hundred * dozens * singe;

        System.out.println("Число 123 содержит:");
        System.out.println("сотен: " + hundred);
        System.out.println("десятков: " + dozens);
        System.out.println("единиц: " + singe);
        System.out.println("Сумма его цифр: " + sum);
        System.out.println("Произведение цифр: " + multiply);

        System.out.println("\n8. 2 вариант - Вывод количества сотен, десятков и единиц числа:");

        int hundred2 = digital / 100;
        int dozens2 = digital % 100 / 10;
        int singe2 = digital % 10;
        int sum2 = hundred2 + dozens2 + singe2;
        int multiply2 = hundred2 * dozens2 * singe2;

        System.out.println("Число 123 содержит:");
        System.out.println("сотен: " + hundred2);
        System.out.println("десятков: " + dozens2);
        System.out.println("единиц: " + singe2);
        System.out.println("Сумма его цифр: " + sum2);
        System.out.println("Произведение цифр: " + multiply2);

        System.out.println("\n9. Вывод времени (кол-во секунд 86399):");

        int allSeconds = 86399; 
        int hours = allSeconds / 3600;
        int minutes = allSeconds / 60 % 60;
        int seconds = allSeconds % 60;

        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}