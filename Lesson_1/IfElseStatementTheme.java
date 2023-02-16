public class IfElseStatementTheme {

    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык amountWithdrawalBanknote10ava:");

        int age = 27;
        float height = 1.70f;
        boolean male = false;
        String name = "Max";

        if (age > 20) {
            System.out.println("Your age has passed!");
        } else {
            System.out.println("Your age has NOT passed!");
        }

        if (male) {
            System.out.println("Available only for Male.");
        } else {
            System.out.println("Available only for Female.");
        }

        if (height < 1.80) {
            System.out.println("You are not Brad Pitt");
        } else {
            System.out.println("You are Brad Pitt");
        }

        char firstLetterName = name.charAt(0);

        if (firstLetterName == 'M') {
            System.out.println("You are Max");
        } else if (firstLetterName == 'I') {
            System.out.println("You are NOT Max");
        } else {
            System.out.println("I don't know who are you.");
        }

        System.out.println("\n2. Поиск max и min числа:");

        int num1 = 10;
        int num2 = 15;

        if (num1 == num2) {
            System.out.println("The numbers are equal" );
        } else if (num1 < num2) {
            System.out.println(num2 + " more than " + num1 + ", " + "number " + num2 + " = max");
        } else {
            System.out.println(num1 + " more than " + num2 + ", " + "number " + num1 + " = max");
        }

        System.out.println("\n3. Проверка числа:");

        int num = 0;

        if (num != 0) {
            if (num % 2 == 0) {
                System.out.println(num + " is even");
            } else {
                System.out.println(num + " is odd");
            }
            if (num < 0) {
                System.out.println(num + " < 0");
            } else {
                System.out.println(num + " > 0");
            }
        } else {
            System.out.println(num + " =" + " 0");
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах:");

        int num3 = 123;
        int num4 = 223;
        boolean equalHundreds = num3 / 100 == num4 / 100;
        boolean equalTens = num3 % 100 / 10 == num4 % 100 / 10;
        boolean equalOnes = num3 % 10 == num4 % 10;

        System.out.println("initial numbers: " + num3 + ", " + num4);

        if (equalHundreds || equalTens || equalOnes) {
            if (equalHundreds) {
                System.out.println("Разряд сотен равны " + num3 / 100 + " : " + num4 / 100);
            }
            if (equalTens) {
                System.out.println("Разряд десяток равен " + num3 % 100 / 10 + " : "
                        + num4 % 100 / 10);
            }
            if (equalOnes) {
                System.out.println("Разряд единиц равен " + num3 % 10 + " : " + num4 % 10);
            }
        } else {
            System.out.println("Don't have the same numbers");
        }

        System.out.println("\n5. Определение символа по его коду:");

        char ch = '\u0057';

        if (ch >= '0' && ch <= '9') {
            System.out.println("This is number: " + ch);
        } else if (ch >= 'A' && ch <= 'Z') {
            System.out.println("This is letter Uppercase: " + ch);
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println("This is Letter Lowercase: " + ch);
        } else {
            System.out.println("This is another symbol");
        }

        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %:");

        float deposit = 300000;
        int percent = 10;

        if (deposit > 0 && deposit < 100000) {
            percent = 5;
        } else if (deposit >= 100000 && deposit < 300000) {
            percent = 7;
        } else if (deposit <= 0) {
            System.out.println("Your deposit can't be 0");
        }

        float profit = deposit / 100 * percent;
        float depositWithProfit = deposit + profit;

        System.out.println("Deposit amount: " + deposit + " RUB");
        System.out.println("Profit net: " + profit + " RUB");
        System.out.println("All amount: " + depositWithProfit + " RUB");

        System.out.println("\n7. Определение оценки по предметам:");

        float historyPercent = 59;
        float programmingPercent = 91;
        float historyGrade = 2;
        float programmingGrade = 2;

        if (historyPercent > 60 && historyPercent <= 73) {
            historyGrade = 3;
        } else if (historyPercent > 73 && historyPercent <= 91) {
            historyGrade = 4;
        } else if (historyPercent > 91) {
            historyGrade = 5;
        }

        if (programmingPercent > 60 && programmingPercent <= 73) {
            programmingGrade = 3;
        } else if (programmingPercent > 73 && programmingPercent <= 91) {
            programmingGrade = 4;
        } else if (programmingPercent > 91) {
            programmingGrade = 5;
        }

        float averageGrade = (historyGrade + programmingGrade) / 2;
        float averagePercent = (historyPercent + programmingPercent) / 2;

        System.out.println(historyGrade + " history lesson grade");
        System.out.println(programmingGrade + " programming lesson grade");
        System.out.println("Average grade of subamountWithdrawalBanknote10ects: " + averageGrade);
        System.out.println("Average percent of subamountWithdrawalBanknote10ects: "+ averagePercent + "%");

        System.out.println("\n8. Расчет прибыли за год:");

        int rentMonth = 5000;
        int sellMonth = 13000;
        int priceGoodsMonth = 9000;

        int profitPureYear = (sellMonth - (rentMonth + priceGoodsMonth)) * 12;

        if (profitPureYear > 0) {
            System.out.println("Profit of the year: +" + profitPureYear + " RUB");
        } else {
            System.out.println("Profit of the year: " + profitPureYear + " RUB");
        }

        System.out.println("\n9. Подсчет количества банкнот:");

        int withdrawalSum = 567;

        int amountBanknote100 = 10;
        int amountBanknote10 = 5;
        int amountBanknote1 = 50;

        int withdrawal100 = withdrawalSum / 100;
        int withdrawal10 = withdrawalSum / 10 % 10;
        int withdrawal1 = withdrawalSum % 10;

        if (withdrawal100 > amountBanknote100) {
            withdrawal10 += (withdrawal100 - amountBanknote100) * 10;
            withdrawal100 = amountBanknote100;
        }
        if (withdrawal10 > amountBanknote10) {
            withdrawal1 += (withdrawal10 - amountBanknote10) * 10;
            withdrawal10 = amountBanknote10;
        }
        if (withdrawal1 > amountBanknote1) {
            System.out.println("Количества банкнот не хватает для снятия.");
        } else if (withdrawal1 <= 0) {
            System.out.println("Количество банкнот не может быть 0.");
        } else {
            System.out.println("Количество банкнот по 100: " + withdrawal100);
        System.out.println("Всего снимаем по 100 usd: " + withdrawal100 * 100 );
        System.out.println("Количество банкнот по 10: " + withdrawal10);
        System.out.println("Всего снимаем по 10 usd: " + withdrawal10 * 10);
        System.out.println("Количество банкнот по 1: " + withdrawal1);
        System.out.println("Всего снимаем по 1 usd: " + withdrawal1);
        System.out.println("Общая сумма к снятию: " + (withdrawal100 * 100 + withdrawal10 * 10 
                + withdrawal1));
        }
    }
}