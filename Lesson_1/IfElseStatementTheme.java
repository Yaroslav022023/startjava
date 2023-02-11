public class IfElseStatementTheme {

    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java:");

        int age = 27;
        float height = 1.70f;
        boolean genderM = false;
        String name = "Max";

        if (age > 20) {
            System.out.println("Your age has passed!");
        } else {
            System.out.println("Your age has NOT passed!");
        }

        if (genderM) {
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
        boolean hundredsEqual = num3 / 100 == num4 / 100;
        boolean tensEqual = num3 % 100 / 10 == num4 % 100 / 10;
        boolean unitsEqual = num3 % 10 == num4 % 10;

        System.out.println("initial numbers: " + num3 + ", " + num4);

        if (hundredsEqual || tensEqual || unitsEqual) {
            if (hundredsEqual) {
                System.out.println("Разряд сотен равны " + num3 / 100 + " : " + num4 / 100);
            }
            if (tensEqual) {
                System.out.println("Разряд десяток равен " + num3 % 100 / 10 + " : " + num4 % 100 / 10);
            }
            if (unitsEqual) {
                System.out.println("Разряд единиц равен " + num3 % 10 + " : " + num4 % 10);
            }
        } else {
            System.out.println("Don't have the same numbers");
        }

        System.out.println("\n5. Определение символа по его коду:");

        char ch = '\u0057';

        if (ch >= '0' & ch <= '9') {
            System.out.println("This is number: " + ch);
        } else if (ch >= 'A' & ch <= 'Z') {
            System.out.println("This is letter Uppercase: " + ch);
        } else if (ch >= 'a' & ch <= 'z') {
            System.out.println("This is Letter Lowercase: " + ch);
        } else {
            System.out.println("This is another symbol");
        }

        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %:");

        float deposit = 300000;
        float profit = 0;

        if (deposit > 0 & deposit < 100000) {
            profit = (deposit / 100 * 5);
        } else if (deposit >= 100000 & deposit < 300000) {
            profit = (deposit / 100 * 7);
        } else if (deposit >= 300000) {
            profit = (deposit / 100 * 10);
        } else {
            System.out.println("Your deposit can't be 0");
        }

        float depositWithProfit = deposit + profit;

        System.out.println("Deposit amount: " + deposit + " RUB");
        System.out.println("Profit net: " + profit + " RUB");
        System.out.println("All amount: " + depositWithProfit + " RUB");

        System.out.println("\n7. Определение оценки по предметам:");

        float historyLesson = 59;
        float programmingLesson = 91;
        float historyGrade = 0;
        float programmingGrade = 0;

        if (historyLesson > 0 & historyLesson <= 60) {
            historyGrade = 2;
        } else if (historyLesson > 60 & historyLesson <= 73) {
            historyGrade = 3;
        } else if (historyLesson > 73 & historyLesson <= 91) {
            historyGrade = 4;
        }

        if (programmingLesson > 0 & programmingLesson <= 60) {
            programmingGrade = 2;
        } else if (programmingLesson > 60 & programmingLesson <= 73) {
            programmingGrade = 3;
        } else if (programmingLesson > 73 & programmingLesson <= 91) {
            programmingGrade = 4;
        }

        float averageGrade = (historyGrade + programmingGrade) / 2;
        float averagePercent = (historyLesson + programmingLesson) / 2;

        System.out.println(historyGrade + " history lesson grade");
        System.out.println(programmingGrade + " programming lesson grade");
        System.out.println("Average grade of subjects: " + averageGrade);
        System.out.println("Average percent of subjects: " + averagePercent + "%");

        System.out.println("\n8. Расчет прибыли за год:");

        int rentMonth = 5000;
        int sellMonth = 13000;
        int priceGoodsMonth = 9000;

        int profitPureYear = (sellMonth * 12) - ((rentMonth * 12) + (priceGoodsMonth * 12));

        if (profitPureYear > 0) {
            System.out.println("Profit of the year: " + "+" + profitPureYear + " RUB");
        } else {
            System.out.println("Profit of the year: " + profitPureYear + " RUB");
        }

        System.out.println("\n9. Подсчет количества банкнот:");

        int withdrawalSum = 567;
        int banknote100 = 100;
        int banknote10 = 10;
        int banknote1 = 1;

        int amountBanknote100 = 10;
        int amountBanknote10 = 5;
        int amountBanknote1 = 50;

        int i = 0;
        int j = 0;
        int k = 0;
        int totalAmountToWithdrawal = 0;
        int possibleWithdrawal = 0;

        int amountSum = banknote100 * amountBanknote100 + banknote10 * amountBanknote10 + banknote1 * amountBanknote1;

        if (withdrawalSum <= amountSum & withdrawalSum > 0) {
            if (withdrawalSum / banknote100 <= amountBanknote100) {
                i = withdrawalSum / banknote100;
                System.out.println("Количество банкнот по 100: " + i);
                i *= banknote100;
                System.out.println("Всего снимаем по 100 usd: " + i + " usd"); 
                withdrawalSum -= i;
            } else {
                i = amountBanknote100 * banknote100;
                System.out.println("Количество банкнот по 100: " + amountBanknote100);
                System.out.println("Всего снимаем по 100 usd: " + i + " usd");
                withdrawalSum -= i;
            }
            if (withdrawalSum % banknote100 / banknote10 <= amountBanknote10 & withdrawalSum % banknote10 != 0) {
                j = withdrawalSum % banknote100 / banknote10;
                System.out.println("Количество банкнот по 10: " + j);
                j *= banknote10;
                System.out.println("Всего снимаем по 10 usd: " + j + " usd"); 
                withdrawalSum -= j;
            } else {
                j = amountBanknote10 * banknote10;
                System.out.println("Количество банкнот по 10: " + amountBanknote10);
                System.out.println("Всего снимаем по 10 usd: " + j + " usd");
                withdrawalSum -= j;
            }
            if (withdrawalSum <= amountBanknote1 * banknote1) {
                k = withdrawalSum;
                totalAmountToWithdrawal = i + j + k;
                System.out.println("Количество банкнот по 1: " + withdrawalSum);
                System.out.println("Всего снимаем по 1 usd: " + k + " usd");
                System.out.println("Общая сумма к снятию: " + totalAmountToWithdrawal + " usd");
            } else {
                possibleWithdrawal = i + j + amountBanknote1;
                System.out.print("В банкомате не хватает купюр по 1 usd. ");
                System.out.println("Возможная сумма к снятию: " + possibleWithdrawal + " usd");
            }
        } else if (withdrawalSum <= 0) {
            System.out.println("Сумма не может быть 0");
        } else {
            System.out.print("В банкомате недостаточно денег для снятия вашей суммы. ");
            System.out.println("Доступно для снятия: " + amountSum + " usd");
        }
    }
}