package com.startjava.lesson_1.base;

public class CyclesTheme {

    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");

        int startRange = -10;
        int endRange = 21;
        int counter = startRange;
        int sumEvenNumbers = 0;
        int sumOddNumbers = 0;
        do {
            if (counter % 2 == 0) {
                sumEvenNumbers += counter;
            } else {
                sumOddNumbers += counter;
            }
            counter++;
        } while (counter <= endRange);
        System.out.print("В отрезке [" + startRange + ", " + endRange + "]");
        System.out.println(" сумма четных чисел = " + sumEvenNumbers + ", а нечетных = " + sumOddNumbers);

        System.out.println("\n2. Вывод чисел между min и max в порядке убывания");

        int a = 10;
        int b = 5;
        int c = -1;

        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }

        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        System.out.print("Интервал (min = " + min + ", max = " + max + "): ");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");

        int number = 1234;
        int sumDigits = 0;
        System.out.print("Реверсивное число = ");
        while (number > 0) {
            int digit = number % 10;
            System.out.print(digit);
            sumDigits += digit;
            number /= 10;
        }
        System.out.println(", сумма цифр = " + sumDigits);

        System.out.println("\n4. Вывод чисел в несколько строк");

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
        for (; columns > 0 && columns != 5; columns--) {
            System.out.printf("%4d ", 0);
        }

        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность");

        number = 3242592;
        int countTwos = 0;
        System.out.print("В " + number);
        while (number > 0) {
            if (number % 10 == 2) countTwos++;
            number /= 10;
        }
        String evenOrOdd = (countTwos % 2 == 0) ? " четное" : " нечетное";
        System.out.println(evenOrOdd + " (" + countTwos + ") количество двоек\n");

        System.out.println("6. Вывод геометрических фигур");

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

        int triangleHeight = 3;
        boolean isTop = false;
        int row = 1;
        do {
            int symbols = 0;
            do {
                System.out.print("$");
                symbols++;
            } while (symbols < row);
            System.out.println();
            if (row == triangleHeight) {
                isTop = true;
            }
            row = isTop ? row - 1 : row + 1;
        } while (row > 0);

        System.out.println("\n7. Отображение ASCII-символов");

        System.out.printf("%s %11s %13s %n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (char symbol = 33; symbol <= '0'; symbol += 2) {
            System.out.printf("%4d %10c            %-1s %n", (int) symbol, symbol, Character.getName(symbol));
        }
        for (char symbol = 'a'; symbol <= 'z'; symbol += 2) {
            if ((int) symbol % 2 != 0) symbol++;
            System.out.printf("%4d %10c            %-1s %n", (int) symbol, symbol, Character.getName(symbol));
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");

        number = 1234321;
        int copyNumber = number;
        int reverseNumber = 0;
        while (number > 0) {
            reverseNumber = reverseNumber * 10 + number % 10;
            number /= 10;
        }
        String palindromeOrNot = (copyNumber == reverseNumber) ? "палиндром" : "не палиндром";
        System.out.println("Число " + copyNumber + " - " + palindromeOrNot);

        System.out.println("\n9. Проверка, является ли число счастливым");

        number = 123321;
        int leftHalfDigits = number / 1000;
        int rightHalfDigits = number % 1000;
        int copyLeftHalfDigits = leftHalfDigits;
        int copyRightHalfDigits = rightHalfDigits;
        int sumLeftHalfDigits = 0;
        int sumRightHalfDigits = 0;
        while (leftHalfDigits > 0) {
            sumLeftHalfDigits += leftHalfDigits % 10;
            leftHalfDigits /= 10;
            sumRightHalfDigits += rightHalfDigits % 10;
            rightHalfDigits /= 10;
        }
        String luckyNumberOrNot = (sumLeftHalfDigits == sumRightHalfDigits) ? "счастливое" : "несчастливое";
        System.out.println("Число " + number + " - " + luckyNumberOrNot);
        System.out.println("Сумма " + copyLeftHalfDigits + " = " + sumLeftHalfDigits);
        System.out.println("Сумма " + copyRightHalfDigits + " = " + sumRightHalfDigits);

        System.out.println("\n10. Вывод таблицы умножения Пифагора");

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