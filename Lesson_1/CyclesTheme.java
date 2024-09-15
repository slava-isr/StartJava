public class CyclesTheme {
    public static void main(String[] args) {
        System.out.printf("1. Подсчет суммы четных и нечетных чисел%n");

        int startRange = -10;
        int endRange = 21;
        int number = startRange;
        int sumEvenNumbers = 0;
        int sumOddNumbers = 0;
        do {
            if (number % 2 == 0) {
                sumEvenNumbers += number;
            } else {
                sumOddNumbers += number;
            }
            number++;
        } while (number <= endRange);
        System.out.printf("%nВ отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d",
                startRange, endRange, sumEvenNumbers, sumOddNumbers);

        System.out.printf("%n%n2. Вывод чисел между min и max в порядке убывания%n");

        int a = 10;
        int b = 5;
        int c = -1;

        int min;
        if (a < b && a < c) {
            min = a;
        } else if (b < c) {
            min = b;
        } else {
            min = c;
        }

        int max;
        if (a > b && a > c) {
            max = a;
        } else if (b > c) {
            max = b;
        } else {
            max = c;
        }

        System.out.printf("%nИнтервал (min = %d, max = %d): ", min, max);
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.printf("%n%n3. Вывод реверсивного числа и суммы его цифр%n");

        number = 1234;
        int sumDigits = 0;
        System.out.printf("%nРеверсивное число = ");
        while (number > 0) {
            int digit = number % 10;
            System.out.print(digit);
            sumDigits += digit;
            number = number / 10;
        }
        System.out.printf(", сумма цифр = %d", sumDigits);

        System.out.printf("%n%n4. Вывод чисел в несколько строк%n%n");

        int columns = 5;
        for (int i = 1; i < 24; i++) {
            if (i % 2 == 0) {
                System.out.printf("%4d ", i);
                columns--;
                if (columns == 0) {
                    columns = 5;
                    System.out.println();
                }
            }
        }
        for (; columns > 0; columns--) {
            System.out.printf("%4d ", 0);
        }

        System.out.printf("%n%n5. Проверка количества двоек числа на четность/нечетность%n");

        number = 3242592;
        int countTwos = 0;
        System.out.printf("%nВ %d ", number);
        while (number > 0) {
            int digit = number % 10;
            if (digit == 2) countTwos++;
            number = number / 10;
        }
        System.out.printf("%s (%d) количество двоек", (countTwos % 2 == 0) ? "четное" : "нечетное", countTwos);

        System.out.printf("%n%n6. Вывод геометрических фигур%n%n");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();

        int triangleBase = 5;
        while (triangleBase > 0) {
            int symbols = triangleBase;
            while (symbols > 0) {
                System.out.print('#');
                symbols--;
            }
            System.out.println();
            triangleBase--;
        }
        System.out.println();

        // Заданная высота треугольника
        int triangleHeight = 3;
        // Флаг для изменения направления
        boolean isTop = false;
        // Индекс для внешнего цикла (строки)
        int row = 1;
        do {
            // Индекс для внутреннего цикла (символы)
            int symbols = 0;
            // Печать символов
            do {
                System.out.print("$");
                symbols++;
            } while (symbols < row);
            // Переход на новую строку
            System.out.println();
            // Логика изменения направления (если достигли высоты)
            if (row == triangleHeight) {
                isTop = true;
            }
            // Увеличиваем или уменьшаем кол-во символов
            row = isTop ? row - 1 : row + 1;
        } while (row > 0);

        System.out.printf("%n7. Вывод ASCII-символов%n");

        System.out.printf("%n%s %12s %14s %n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (char symbol = 33; symbol <= '0'; symbol += 2) {
            System.out.printf("%4d %11c \t\t\t %-1s %n", (int) symbol, symbol, Character.getName(symbol));
        }
        for (char symbol = 'a'; symbol <= 'z'; symbol += 2) {
            System.out.printf("%4d %11c \t\t\t %-1s %n", (int) symbol, symbol, Character.getName(symbol));
        }

        System.out.printf("%n8. Проверка, является ли число палиндромом%n");

        int initNumber = number = 1234321;
        int reverseNumber = 0;
        while (number > 0) {
            reverseNumber = reverseNumber * 10 + number % 10;
            number /= 10;
        }
        System.out.printf("%nЧисло %d - %s", initNumber, (initNumber == reverseNumber) ? "палиндром" : "не палиндром");

        System.out.printf("%n%n9. Проверка, является ли число счастливым%n");

        number = 123321;
        int startDigits = number / 1000;
        int endDigits = number % 1000;
        int copyStartDigits = startDigits;
        int copyEndDigits = endDigits;
        int sumStartDigits = 0;
        int sumEndDigits = 0;
        while (startDigits > 0) {
            sumStartDigits += startDigits % 10;
            startDigits /= 10;
            sumEndDigits += endDigits % 10;
            endDigits /= 10;
        }
        System.out.printf("%nЧисло %d - %s%n", number, sumStartDigits == sumEndDigits ? "счастливое" : "несчастливое");
        System.out.printf("Сумма цифр %d = %d%n", copyStartDigits, sumStartDigits);
        System.out.printf("Сумма %d = %d", copyEndDigits, sumEndDigits);

        System.out.printf("%n%n10. Вывод таблицы умножения Пифагора%n%n");

        for (int i = 1; i <= 9; i++) {
            if (i > 1) {
                System.out.printf("%4d |", i);
            } else {
                System.out.printf("%4c |", ' ');
            }
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%4d", i * j);
            }
            if (i == 1) {
                System.out.printf("%n   -----------------------------------%n");
            } else {
                System.out.println();
            }
        }
    }
}
