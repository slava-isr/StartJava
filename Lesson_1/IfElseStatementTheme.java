import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java\n");

        boolean isMale = true;

        if (!isMale) {
            System.out.println("В Летуаль сегодня скидки для тебя");
        } else {
            System.out.println("Мужик, к тебе никаких вопросов, ты красавчик");
        }

        byte age = 31;

        if (age > 18) {
            System.out.println("Ты взрослый, тебе уже можно!");
        } else {
            System.out.println("Ты еще маленький, иди спать!");
        }

        double height = 1.78;

        if (height < 1.8) {
            System.out.println("Нет-нет, ты не гном, успокойся");
        } else {
            System.out.println("Ух ты, какой высокий!");
        }

        char firstLetterOfName = "Viacheslav".charAt(0);

        if (firstLetterOfName == 'M') {
            System.out.println("Может быть, ты Максим?");
        } else if (firstLetterOfName == 'I') {
            System.out.println("Может быть, тебя зовут Ира?");
        } else {
            System.out.println("Ты явно не Ира и не Максим...");
        }

        System.out.println("\n2. Поиск большего числа\n");

        int firstDigit = 7;
        int secondDigit = 1;

        if (firstDigit == secondDigit) {
            System.out.printf("Числа %d и %d равны\n", firstDigit, secondDigit);
        } else if (firstDigit > secondDigit) {
            System.out.printf("Число %d больше %d\n", firstDigit, secondDigit);
        } else {
            System.out.printf("Число %d меньше %d\n", firstDigit, secondDigit);
        }

        System.out.println("\n3. Проверка числа\n");

        int someNumber = -15;

        if (someNumber == 0) {
            System.out.println("Переменная \"someNumber\" равна нулю");
        } else {
            if (someNumber > 0) {
                System.out.printf("%d является положительным ", someNumber);
            } else {
                System.out.printf("%d является отрицательным ", someNumber);
            }

            if (someNumber % 2 == 0) {
                System.out.println("и четным");
            } else {
                System.out.println("и нечетным");
            }
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах\n");

        int firstNumber = 123;
        int secondNumber = 123;

        int firstHundreds = firstNumber / 100;
        int firstTens = firstNumber / 10 % 10;
        int firstOnes = firstNumber % 10;

        int secondHundreds = secondNumber / 100;
        int secondTens = secondNumber / 10 % 10;
        int secondOnes = secondNumber % 10;

        if ((firstHundreds == secondHundreds) || (firstTens == secondTens) || (firstOnes == secondOnes)) {
            System.out.printf("В цифрах %d и %d есть одинаковые:\n", firstNumber, secondNumber);

            if (firstHundreds == secondHundreds) {
                System.out.printf("\t- сотни равные %d\n", firstHundreds);
            }

            if (firstTens == secondTens) {
                System.out.printf("\t- десятки равные %d\n", firstTens);
            }

            if (firstOnes == secondOnes) {
                System.out.printf("\t- единицы равные %d\n", firstOnes);
            }
        } else {
            System.out.println("Цифры, стоящие в одних и тех же разрядах, не равны!");
        }

        System.out.println("\n5. Определение символа по его коду\n");

        char symbol = '\u0057';

        if (symbol >= 'A' && symbol <= 'Z') {
            System.out.printf("'%c' - большая буква\n", symbol);
        } else if (symbol >= 'a' && symbol <= 'z') {
            System.out.printf("'%c' - маленькая буква\n", symbol);
        } else if (symbol >= '0' && symbol <= '9') {
            System.out.printf("'%c' - цифра\n", symbol);
        } else {
            System.out.printf("'%c' - ни буква и ни цифра\n", symbol);
        }

        System.out.println("\n6. Подсчет начисленных банком %\n");

        double depositAmount = 321_123.59;
        double interestOnDeposit = 0.07;

        if (depositAmount > 300_000) {
            interestOnDeposit = 0.1;
        } else if (depositAmount < 100_000) {
            interestOnDeposit = 0.05;
        }

        double accrualAmount = depositAmount * interestOnDeposit;
        double totalAmountWithPct = depositAmount + accrualAmount;

        System.out.println("Сумма вклада: " + depositAmount);
        System.out.println("Сумма начисленного %: " + accrualAmount);
        System.out.println("Итоговая сумма с %: " + totalAmountWithPct);

        System.out.println("\n7. Определение оценки по предметам\n");

        int historyPct = 59;
        int programmingPct = 92;
        int historyGrade = historyPct > 91 ? 5 : historyPct > 73 ? 4 : historyPct > 60 ? 3 : 2;
        int programmingGrade = programmingPct > 91 ? 5 : programmingPct > 73 ? 4 : programmingPct > 60 ? 3 : 2;

        System.out.println("Оценки по предметам:");
        System.out.println("\t- История: " + historyGrade);
        System.out.println("\t- Программирование: " + programmingGrade);

        double averageGrade = (historyGrade + programmingGrade) / 2.0;
        double averagePct = (historyPct + programmingPct) / 2.0;

        System.out.printf("Средний балл: %.2f\n", averageGrade);
        System.out.printf("Средний процент: %.2f%%\n", averagePct);

        System.out.println("\n8. Расчет годовой прибыли\n");

        double monthlyRevenue = 13025.233;
        double premisesRental = 5123.018;
        double productionCost = 9001.729;
        double annualProfit = (monthlyRevenue - premisesRental - productionCost) * 12;
        System.out.printf("Прибыль за год: %s%f руб.\n", (annualProfit > 0) ? "+" : "", annualProfit);

        System.out.println("\n9. *Расчет годовой прибыли\n");

        BigDecimal depositAmountBd = new BigDecimal("321123.59");
        BigDecimal interestOnDepositBd;

        if (depositAmountBd.compareTo(new BigDecimal("300000")) > 0) {
            interestOnDepositBd = new BigDecimal("0.1");
        } else if (depositAmountBd.compareTo(new BigDecimal("100000")) < 0) {
            interestOnDepositBd = new BigDecimal("0.05");
        } else {
            interestOnDepositBd = new BigDecimal("0.07");
        }

        BigDecimal accrualAmountBd = depositAmountBd.multiply(interestOnDepositBd)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalAmountWithPctBd = depositAmountBd.add(accrualAmountBd)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("Сумма вклада: " + depositAmountBd);
        System.out.println("Сумма начисленного %: " + accrualAmountBd);
        System.out.println("Итоговая сумма с %: " + totalAmountWithPctBd);

        System.out.println("\n10. *Подсчет начисленных банком %\n");

        BigDecimal monthlyRevenueBd = new BigDecimal("13025.233");
        BigDecimal premisesRentalBd = new BigDecimal("5123.018");
        BigDecimal productionCostBd = new BigDecimal("9001.729");
        BigDecimal annualProfitBd = monthlyRevenueBd
                .subtract(premisesRentalBd)
                .subtract(productionCostBd)
                .multiply(new BigDecimal("12"))
                .setScale(2, RoundingMode.HALF_UP);
        String numericSign = (annualProfitBd.compareTo(new BigDecimal("0")) > 0) ? "+" : "";

        System.out.printf("Прибыль за год: %s%s руб.\n", numericSign, annualProfitBd);
    }
}
