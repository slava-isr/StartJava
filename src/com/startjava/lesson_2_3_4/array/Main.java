package com.startjava.lesson_2_3_4.array;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("============================== 1. Реверс значений массива ==============================");
        int[] sourceIntNumbers = new int[]{};
        int[] reversedNumbers = Arrays.reverse(sourceIntNumbers);
        Console.displayResult(sourceIntNumbers, reversedNumbers);
        sourceIntNumbers = null;
        reversedNumbers = Arrays.reverse(sourceIntNumbers);
        Console.displayResult(sourceIntNumbers, reversedNumbers);
        sourceIntNumbers = new int[]{6, 8, 9, 1};
        reversedNumbers = Arrays.reverse(sourceIntNumbers);
        Console.displayResult(sourceIntNumbers, reversedNumbers);
        sourceIntNumbers = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversedNumbers = Arrays.reverse(sourceIntNumbers);
        Console.displayResult(sourceIntNumbers, reversedNumbers);

        System.out.println("=============================== 2. Вычисление факториала ===============================");
        long[] sourceLongNumbers = new long[]{};
        Console.displayResult(sourceLongNumbers, Arrays.calculate(sourceLongNumbers));
        sourceLongNumbers = null;
        Console.displayResult(sourceLongNumbers, Arrays.calculate(sourceLongNumbers));
        sourceLongNumbers = new long[]{8, 0, 9};
        Console.displayResult(sourceLongNumbers, Arrays.calculate(sourceLongNumbers));
        sourceLongNumbers = new long[]{-3, 1, 7, 13};
        Console.displayResult(sourceLongNumbers, Arrays.calculate(sourceLongNumbers));
        sourceLongNumbers = new long[]{-22, -0};
        Console.displayResult(sourceLongNumbers, Arrays.calculate(sourceLongNumbers));

        System.out.println("============= 3. Удаление элементов массива, превышающих заданное значение =============");
        int[] thresholdValueIndexes = {-1, 15, 0, 14};
        for (int index : thresholdValueIndexes) {
            float[] sourceValues = Arrays.createValues(15);
            Console.displayResult(sourceValues, Arrays.resetValues(sourceValues, index), index);
        }

        System.out.println("================ 4. Вывод отсортированных символов в виде треугольника =================");
        Console.displayResult(Arrays.sortCharacters('0', '9', true));
        Console.displayResult(Arrays.sortCharacters('/', '!', false));
        Console.displayResult(Arrays.sortCharacters('A', 'J', false));

        System.out.println("====================== 5. Заполнение массива уникальными числами =======================");
        Console.displayResult(Arrays.createNumbers(-10, 20), 23);
        Console.displayResult(Arrays.createNumbers(-30, 10), 10);
        Console.displayResult(Arrays.createNumbers(-34, -34), 0);
        Console.displayResult(Arrays.createNumbers(-1, 2), -3);
        Console.displayResult(Arrays.createNumbers(5, -8), 2);

        System.out.println("====================== 6. Вывод текста с эффектом пишущей машинки ======================");
        String jamesQuote = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        String robertsQuote = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        Arrays.type(jamesQuote);
        Arrays.type(robertsQuote);
        Arrays.type(null);
        Arrays.type("");
    }
}