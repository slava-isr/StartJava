package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {

    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера\n");

        byte generation = 7;
        short ramSize = 8192;
        int gpuMemory = 4096;
        long ssdCapacity = 1024L;
        float cpuFrequency = 4.5F;
        double screenSize = 15.6;
        char modelType = 'A';
        boolean inStock = false;
        System.out.println("Поколение: " + generation);
        System.out.println("Размер оперативной памяти: " + ramSize);
        System.out.println("Размер графической памяти: " + gpuMemory);
        System.out.println("Размер жесткого диска: " + ssdCapacity);
        System.out.println("Частота процессора: " + cpuFrequency);
        System.out.println("Диагональ экрана: " + screenSize);
        System.out.println("Тип модели: " + modelType);
        System.out.println("Наличие на складе: " + inStock);

        System.out.println("\n2. Расчет стоимости товара со скидкой\n");

        double penPrice = 105.5;
        double bookPrice = 235.83;
        double discount = 0.11;
        double basePrice = penPrice + bookPrice;
        double discountAmount = basePrice * discount;
        double discountPrice = basePrice - discountAmount;

        System.out.println("Стоимость товаров без скидки: " + basePrice);
        System.out.println("Сумма скидки: " + discountAmount);
        System.out.println("Стоимость товаров со скидкой: " + discountPrice);

        System.out.println("\n3. Вывод слова JAVA\n");

        System.out.println("    J    a  v     v  a");
        System.out.println("    J   a a  v   v  a a");
        System.out.println(" J  J  aaaaa  V V  aaaaa");
        System.out.println("  JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов\n");

        byte byteMax = Byte.MAX_VALUE;
        System.out.println("Первоначальное значение byte: " + byteMax);
        System.out.println("Значение byte после инкремента на единицу: " + ++byteMax);
        System.out.println("Значение byte после декремента на единицу: " + --byteMax);

        short shortMax = Short.MAX_VALUE;
        System.out.println("\nПервоначальное значение short: " + shortMax);
        System.out.println("Значение short после инкремента на единицу: " + ++shortMax);
        System.out.println("Значение short после декремента на единицу: " + --shortMax);

        int intMax = Integer.MAX_VALUE;
        System.out.println("\nПервоначальное значение int: " + intMax);
        System.out.println("Значение int после инкремента на единицу: " + ++intMax);
        System.out.println("Значение int после декремента на единицу: " + --intMax);

        long longMax = Long.MAX_VALUE;
        System.out.println("\nПервоначальное значение long: " + longMax);
        System.out.println("Значение long после инкремента на единицу: " + ++longMax);
        System.out.println("Значение long после декремента на единицу: " + --longMax);

        char charMax = Character.MAX_VALUE;
        System.out.println("\nПервоначальное значение char: " + (int) charMax);
        System.out.println("Значение char после инкремента на единицу: " + (int) ++charMax);
        System.out.println("Значение char после декремента на единицу: " + (int) --charMax);

        System.out.println("\n5. Перестановка значений переменных\n");

        int a = 2, b = 5;

        System.out.println("Перестановка с помощью третьей переменной:");
        System.out.println("\tИсходные значения переменных: a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("\tНовые значения переменных: a = " + a + ", b = " + b);

        System.out.println("\nПерестановка с помощью арифметических операций:");
        a += b;
        b = a - b;
        a -= b;
        System.out.println("\tНовые значения переменных: a = " + a + ", b = " + b);

        System.out.println("\nПерестановка с помощью побитовой операции ^:");
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("\tНовые значения переменных: a = " + a + ", b = " + b);

        System.out.println("\n6. Вывод символов и их кодов\n");

        char dollarSymbol = '$';
        char asteriskSymbol = '*';
        char atSignSymbol = '@';
        char verticalBarSymbol = '|';
        char tildeSymbol = '~';

        System.out.println("Код символа: " + (byte) dollarSymbol + "\t\tСимвол: " + dollarSymbol);
        System.out.println("Код символа: " + (byte) asteriskSymbol + "\t\tСимвол: " + asteriskSymbol);
        System.out.println("Код символа: " + (byte) atSignSymbol + "\t\tСимвол: " + atSignSymbol);
        System.out.println("Код символа: " + (byte) verticalBarSymbol + "\tСимвол: " + verticalBarSymbol);
        System.out.println("Код символа: " + (byte) tildeSymbol + "\tСимвол: " + tildeSymbol);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка\n");

        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char openBracket = '(';
        char closeBracket = ')';

        System.out.println("    " + slash + backslash);
        System.out.println("   " + slash + "  " + backslash);
        System.out.println("  " + slash + underscore + openBracket + " " + closeBracket + backslash);
        System.out.println(" " + slash + "      " + backslash);
        System.out.println("" + slash + underscore + underscore + underscore + underscore
                + slash + backslash + underscore + underscore + backslash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа\n");

        int number = 123;
        int hundreds = number / 100;
        int tens = number / 10 % 10;
        int ones = number % 10;
        int sumDigits = hundreds + tens + ones;
        int productDigits = hundreds * tens * ones;

        System.out.println("Число " + number + " содержит:");
        System.out.println("\t- сотен = " + hundreds);
        System.out.println("\t- десятков = " + tens);
        System.out.println("\t- единиц = " + ones);
        System.out.println("Сумма разрядов = " + sumDigits);
        System.out.println("Произведение разрядов = " + productDigits);

        System.out.println("\n9. Перевод секунд в часы, минуты и секунды\n");

        int totalSeconds = 86399;
        int hh = totalSeconds / 3600;
        int mm = (totalSeconds % 3600) / 60;
        int ss = totalSeconds % 60;

        System.out.printf("%02d:%02d:%02d\n", hh, mm, ss);

        System.out.println("\n10. *Расчет стоимости товара со скидкой\n");

        BigDecimal penPriceBd = new BigDecimal("105.5");
        BigDecimal bookPriceBd = new BigDecimal("235.83");
        BigDecimal discountBd = new BigDecimal("0.11");
        BigDecimal basePriceBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountAmountBd = basePriceBd.multiply(discountBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountPriceBd = basePriceBd.subtract(discountAmountBd).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Стоимость товаров без скидки: " + basePriceBd);
        System.out.println("Сумма скидки: " + discountAmountBd);
        System.out.println("Стоимость товаров со скидкой: " + discountPriceBd);
    }
}
