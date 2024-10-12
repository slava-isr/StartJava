package com.startjava.lesson_2_3_4.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger gipsyDanger = new Jaeger();
        gipsyDanger.setModelName("Gipsy Danger");
        gipsyDanger.setMark("Mark-3");
        gipsyDanger.setOrigin("United States of America");
        gipsyDanger.setHeight(79.25f);
        gipsyDanger.setWeight(1.980f);
        gipsyDanger.setSpeed(7);
        gipsyDanger.setStrength(8);
        gipsyDanger.setArmor(6);
        System.out.println(gipsyDanger + "\n");

        Jaeger coyoteTango = new Jaeger("Coyote Tango", "Mark-1", "Japan", 85.34f, 2.312f, 5, 7, 4);
        System.out.println("Название модели = " + coyoteTango.getModelName());
        System.out.println("Марка = " + coyoteTango.getMark());
        System.out.println("Производитель = " + coyoteTango.getOrigin());
        System.out.println("Высота = " + coyoteTango.getHeight());
        System.out.println("Масса = " + coyoteTango.getWeight());
        System.out.println("Скорость = " + coyoteTango.getSpeed());
        System.out.println("Сила = " + coyoteTango.getStrength());
        System.out.println("Броня = " + coyoteTango.getArmor());
        System.out.println("Работоспособность системы дрифта = " + coyoteTango.isDrift());
        coyoteTango.move();
        System.out.println("Результат поиска кайдзю: " + coyoteTango.scanKaiju());
        coyoteTango.useVortexCannon();
    }
}