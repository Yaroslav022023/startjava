public class IfElseStatementTheme {

    public static void main (String[] args) {

        System.out.println("1. Перевод псевдокода на язык Java:");

        int age = 27;
        float height = 1.70f;
        char mGender = 'm';
        char fGender = 'f';
        char avaliableGender = fGender;
        String name = "Max";

        if (age > 20) {
            System.out.println("Your age has passed!");
        } else {
            System.out.println("Your age has NOT passed!");
        }

        if (avaliableGender != mGender) {
            System.out.println("Available only for Female.");
        } else {
            System.out.println("Enter available.");
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

        if (num1 < num2) {
            System.out.println(num2 + " more than " + num1 + ", " + "number " + num2 + " = max");
        } else if (num1 == num2) {
            System.out.println("The numbers are equal");
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

        System.out.println("initial numbers: " + num3 + ", " + num4);

        if (num3 / 100 == num4 / 100 | num3 % 100 / 10 == num4 % 100 / 10 | num3 % 10 == num4 % 10) {
            if (num3 / 100 == num4 / 100) {
                System.out.println("Разряд сотен равны " + num3 / 100 + " : " + num4 / 100);
            }
            if (num3 % 100 / 10 == num4 % 100 / 10) {
                System.out.println("Разряд десяток равен " + num3 % 100 / 10 + " : " + num4 % 100 / 10);
            }
            if (num3 % 10 == num4 % 10) {
                System.out.println("Разряд единиц равен " + num3 % 10 + " : " + num4 % 10);
            }
        } else {
                System.out.println("Don't have the same numbers");
            }

        System.out.println("\n5. Определение символа по его коду:");

        char ch = '\u0057';

        if (ch >= 48 & ch <= 57) {
            System.out.println("This is number: " + ch);
        } else if (ch >= 65 & ch <= 90) {
            System.out.println("This is letter Uppercase: " + ch);
        } else if (ch >= 97 & ch <= 122) {
            System.out.println("This is Letter Lowercase: " + ch);
        } else {
            System.out.println("This is another symbol");
        }

        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %:");

        float deposit = 300000;

        if (deposit > 0 & deposit < 100000) {
            float profitTo_100k = (deposit / 100 * 5);
            float depositProfitTo_100k = deposit + profitTo_100k;
            System.out.println("Deposit amount: " + deposit + " RUB");
            System.out.println("Profit net: " + profitTo_100k + " RUB");
            System.out.println("All amount: " + depositProfitTo_100k + " RUB");
        } else if (deposit >= 100000 & deposit < 300000) {
            float profit_100k_300k = (deposit / 100 * 7);
            float depositProfit100k_300k = deposit + profit_100k_300k;
            System.out.println("Deposit amount: " + deposit + " RUB");
            System.out.println("Profit net: " + profit_100k_300k + " RUB");
            System.out.println("All amount: " + depositProfit100k_300k + " RUB");
        } else if (deposit >= 300000) {
            float profitFrom_300k = (deposit / 100 * 10);
            float depositProfit_300k = deposit + profitFrom_300k;
            System.out.println("Deposit amount: " + deposit + " RUB");
            System.out.println("Profit net: " + profitFrom_300k + " RUB");
            System.out.println("All amount: " + depositProfit_300k + " RUB");
        } else {
            System.out.println("Your deposit can't be 0");
        }

        System.out.println("\n7. Определение оценки по предметам:");

        float history = 59;
        float programming = 91;
        float historyAverageGRating = 0;
        float programmingAverageGRating = 0;
        float averageScore = (history + programming) / 2;

        if (history <= 60 | programming <= 60) {
            if (history <= 60) {
                System.out.println("2 " + "history");
                historyAverageGRating = 2;
            }
            if (programming <= 60) {
                System.out.println("2 " + "programming");
                programmingAverageGRating = 2;
            } 
        } 
        if (history > 60 & history <= 73 | programming > 60 & programming <= 73) {
            if (history > 60 & history <= 73) {
                System.out.println("3 " + "history");
                historyAverageGRating = 3;
            }
            if (programming > 60 & programming <= 73) {
                System.out.println("3 " + "programming");
                programmingAverageGRating = 3;
            } 
        } 
        if (history > 73 & history <= 91 | programming > 73 & programming <= 91 ) {
            if (history > 73 & history <= 91) {
                System.out.println("4 " + "history");
                historyAverageGRating = 4;
            }
            if (programming > 73 & programming <= 91) {
                System.out.println("4 " + "programming");
                programmingAverageGRating = 4;
            }
        } 
        if (history > 91 | programming > 91 ) {
            if (history > 91) {
                System.out.println("5 " + "history");
                historyAverageGRating = 5;
            }
            if (programming > 91) {
                System.out.println("5 " + "programming");
                programmingAverageGRating = 5;
            }
        }

        float averageRating = (historyAverageGRating + programmingAverageGRating) / 2;

        System.out.println("Average rating of subjects: " + averageRating);
        System.out.println("Average score (%) of subjects: " + averageScore + "%");

        System.out.println("\n8. Расчет прибыли за год:");

        int rentMonth = 5000;
        int sellMonth = 13000;
        int priceGoodsMonth = 9000;

        int rentYear = rentMonth * 12;
        int sellYear = sellMonth * 12;
        int priceGoodsYear = priceGoodsMonth * 12;

        int expensesYear = rentYear + priceGoodsYear;
        int profitPureYear = sellYear - expensesYear;

        System.out.println("Profit of year: " + profitPureYear + " RUB");

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