package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setGender("Кабель");
        wolf.setName("Ява");
        wolf.setColor("Серый");
        wolf.setWeight(39.5f);
        wolf.setAge(9);

        System.out.println("Перед нами волк по кличке " + wolf.getName() + ", это " + wolf.getGender());
        System.out.println("Посмотрите на его красивый " + wolf.getColor() + " цвет");
        System.out.println("Это молодой и грозный " + wolf.getAge() + "-летний волк");
        System.out.println("Весит он " + wolf.getWeight() + " килограмм");
        System.out.println("\nЧто же делает сейчас этот волк? А он сейчас:\n");

        wolf.move();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}