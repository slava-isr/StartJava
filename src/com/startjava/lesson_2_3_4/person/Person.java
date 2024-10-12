package com.startjava.lesson_2_3_4.person;

public class Person {

    String gender = "Мужской";
    String name = "Вячеслав";
    float height = 178.2f;
    float weight = 72.5f;
    short age = 31;

    public void move() {
        System.out.println(name + "идёт");
    }

    public void sit() {
        System.out.println(name + "сидит");
    }

    public void run() {
        System.out.println(name + "бежит");
    }

    public void speak() {
        System.out.println(name + "говорит");
    }

    public void learnJava() {
        System.out.println(name + "учит Java");
    }
}