import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        // 1. Вывод характеристик компьютера
        System.out.println("1. Вывод характеристик компьютера\n");

        byte generation = 7;
        short ramMemory = 8192;
        int gpuMemory = 4096;
        long ssdCapacity = 1024L;
        float cpuFrequency = 4.5F;
        double screenSize = 15.6;
        char typeOfModel = 'A';
        boolean inStock = false;
        System.out.println("Поколение: " + generation);
        System.out.println("Размер оперативной памяти: " + ramMemory);
        System.out.println("Размер графической памяти: " + gpuMemory);
        System.out.println("Размер жесткого диска: " + ssdCapacity);
        System.out.println("Частота процессора: " + cpuFrequency);
        System.out.println("Диагональ экрана: " + screenSize);
        System.out.println("Тип модели: " + typeOfModel);
        System.out.println("Наличие на складе: " + inStock);

        // 2. Расчет стоимости товара со скидкой
        System.out.println("\n2. Расчет стоимости товара со скидкой\n");

        double penPrice = 105.5, bookPrice = 235.83, discount = 0.11;
        double costWithoutDiscount = penPrice + bookPrice;
        double discountAmount = costWithoutDiscount * discount;
        double costWithDiscount = costWithoutDiscount - discountAmount;
        System.out.println("Стоимость товаров без скидки: " + costWithoutDiscount);
        System.out.println("Сумма скидки: " + discountAmount);
        System.out.println("Стоимость товаров со скидкой: " + costWithDiscount);

        // 3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA\n");

        System.out.println("    J    a  v     v  a");
        System.out.println("    J   a a  v   v  a a");
        System.out.println(" J  J  aaaaa  V V  aaaaa");
        System.out.println("  JJ  a     a  V  a     a");

        // 4. Вывод min и max значений целых числовых типов
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

        // 5. Перестановка значений переменных
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

        // 6. Вывод символов и их кодов
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

        // 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка\n");

        char s1 = '/', s2 = '\\', s3 = '_', s4 = '(', s5 = ')';

        System.out.println("    " + s1 + s2);
        System.out.println("   " + s1 + "  " + s2);
        System.out.println("  " + s1 + s3 + s4 + " " + s5 + s2);
        System.out.println(" " + s1 + "      " + s2);
        System.out.println("" + s1 + s3 + s3 + s3 + s3 + s1 + s2 + s3 + s3 + s2);

        // 8. Манипуляции с сотнями, десятками и единицами числа
        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа\n");

        int number = 123;
        int hundreds = number / 100;
        int tens = number % 100 / 10;
        int ones = number % 10;
        int sumOfDigits = hundreds + tens + ones;
        int productOfDigits = hundreds * tens * ones;

        System.out.println("Число " + number + " содержит:");
        System.out.println("\tсотен - " + hundreds);
        System.out.println("\tдесятков - " + tens);
        System.out.println("\tединиц - " + ones);
        System.out.println("Сумма разрядов = " + sumOfDigits);
        System.out.println("Произведение разрядов = " + productOfDigits);

        // 9. Перевод секунд в часы, минуты и секунды
        System.out.println("\n9. Перевод секунд в часы, минуты и секунды\n");

        int totalSeconds = 86399;
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);

        // 10. *Расчет стоимости товара со скидкой
        System.out.println("\n10. *Расчет стоимости товара со скидкой\n");

        BigDecimal penPriceBD = new BigDecimal("105.5");
        BigDecimal bookPriceBD = new BigDecimal("235.83");
        BigDecimal discountBD = new BigDecimal("0.11");

        BigDecimal costWithoutDiscountBD = penPriceBD.add(bookPriceBD);
        BigDecimal discountAmountBD = costWithoutDiscountBD.multiply(discountBD);
        BigDecimal costWithDiscountBD = costWithoutDiscountBD.subtract(discountAmountBD);

        costWithoutDiscountBD = costWithoutDiscountBD.setScale(2, RoundingMode.HALF_UP);
        discountAmountBD = discountAmountBD.setScale(2, RoundingMode.HALF_UP);
        costWithDiscountBD = costWithDiscountBD.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Стоимость товаров без скидки: " + costWithoutDiscountBD);
        System.out.println("Сумма скидки: " + discountAmountBD);
        System.out.println("Стоимость товаров со скидкой: " + costWithDiscountBD);
    }
}
