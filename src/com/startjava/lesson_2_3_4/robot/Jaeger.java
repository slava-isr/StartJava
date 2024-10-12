package com.startjava.lesson_2_3_4.robot;

public class Jaeger {

    private String modelName;
    private String mark;
    private String origin;
    private float height;
    private float weight;
    private int speed;
    private int strength;
    private int armor;

    public Jaeger() {
    }

    public Jaeger(String modelName, String mark, String origin, float height,
            float weight, int speed, int strength, int armor) {
        setModelName(modelName);
        setMark(mark);
        setOrigin(origin);
        setHeight(height);
        setWeight(weight);
        setSpeed(speed);
        setStrength(strength);
        setArmor(armor);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if (modelName.isEmpty()) {
            System.out.println("\"Model name\" не может быть пустым!");
        } else {
            this.modelName = modelName;
        }
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        if (mark.isEmpty()) {
            System.out.println("\"Mark\" не может быть пустым!");
        } else {
            this.mark = mark;
        }
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        if (origin.isEmpty()) {
            System.out.println("\"Origin\" не может быть пустым!");
        } else {
            this.origin = origin;
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if (height <= 0) {
            System.out.println("\"Height\" не может быть меньше или равен нулю!");
        } else {
            this.height = height;
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight <= 0) {
            System.out.println("\"Weight\" не может быть меньше или равен нулю!");
        } else {
            this.weight = weight;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed <= 0) {
            System.out.println("\"Speed\" не может быть меньше или равен нулю!");
        } else {
            this.speed = speed;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            System.out.println("\"Strength\" не может быть меньше или равен нулю!");
        } else {
            this.strength = strength;
        }
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        if (armor <= 0) {
            System.out.println("\"Armor\" не может быть меньше или равен нулю!");
        } else {
            this.armor = armor;
        }
    }

    public boolean isDrift() {
        System.out.println("Вы вошли в дрифт");
        return true;
    }

    public void move() {
        System.out.println("Вы прошли 5 шагов");
    }

    public String scanKaiju() {
        return "Не найдено";
    }

    public void useVortexCannon() {
        System.out.println("Вы используете вихревую пушку");
    }

    public String toString() {
        return String.format("Техническая информация и характеристики:%n" +
                "Model name = %s%n" +
                "Mark = %s%n" +
                "Origin = %s%n" +
                "Height = %.2fm%n" +
                "Weight = %.2f Tons%n" +
                "Speed = %d%n" +
                "Strength = %d%n" +
                "Armor = %d", modelName, mark, origin, height, weight, speed, strength, armor);
    }
}