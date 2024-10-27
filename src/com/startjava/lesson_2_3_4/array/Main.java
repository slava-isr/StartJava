package com.startjava.lesson_2_3_4.array;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("============================== 1. Реверс значений массива ==============================");
        int[][] sourceIntValues = {{}, null, {6, 8, 9, 1}, {13, 8, 5, 3, 2, 1, 1}};
        for (int[] sourceValues : sourceIntValues) {
            Console.printArray(Arrays.reverse(sourceValues));
        }

        System.out.println("=============================== 2. Вычисление факториала ===============================");
        int[][] sourceLongValues = {{}, null, {8, 0, 9}, {-3, 1, 7, 13}, {-22, -0}};
        for (int[] sourceValues : sourceLongValues) {
            Console.printFactorialsExpression(sourceValues, Arrays.factorials(sourceValues));
        }

        System.out.println("============= 3. Удаление элементов массива, превышающих заданное значение =============");
        int[] thresholdValueIndexes = {-1, 15, 0, 14};
        for (int index : thresholdValueIndexes) {
            float[] sourceValues = Arrays.createRandomValues(15);
            Console.printTwoLines(Arrays.resetValues(sourceValues, index), index);
        }

        System.out.println("================ 4. Вывод отсортированных символов в виде треугольника =================");
        Console.drawTriangle(Arrays.sortCharacters('0', '9', true));
        Console.drawTriangle(Arrays.sortCharacters('/', '!', false));
        Console.drawTriangle(Arrays.sortCharacters('A', 'J', false));

        System.out.println("====================== 5. Заполнение массива уникальными числами =======================");
        Console.printMultiline(Arrays.createUniqueValues(-10, 20), 23);
        Console.printMultiline(Arrays.createUniqueValues(-30, 10), 10);
        Console.printMultiline(Arrays.createUniqueValues(-34, -34), 0);
        Console.printMultiline(Arrays.createUniqueValues(-1, 2), -3);
        Console.printMultiline(Arrays.createUniqueValues(5, -8), 2);

        System.out.println("====================== 6. Вывод текста с эффектом пишущей машинки ======================");
        String firstText = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        String secondText = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        Console.type(Arrays.upperCaseRange(firstText));
        Console.type(Arrays.upperCaseRange(secondText));
        Console.type(Arrays.upperCaseRange(null));
        Console.type(Arrays.upperCaseRange(""));
    }
}