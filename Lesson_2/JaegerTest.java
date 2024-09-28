public class JaegerTest {
    public static void main(String[] args) {
        Jaeger fisrtJaeger = new Jaeger();
        fisrtJaeger.setModelName("Gipsy Danger");
        fisrtJaeger.setMark("Mark-3");
        fisrtJaeger.setOrigin("United States of America");
        fisrtJaeger.setHeight(79.25f);
        fisrtJaeger.setWeight(1.980f);
        fisrtJaeger.setSpeed(7);
        fisrtJaeger.setStrength(8);
        fisrtJaeger.setArmor(6);
        System.out.println(fisrtJaeger + "\n");

        Jaeger secondJaeger = new Jaeger("Coyote Tango", "Mark-1", "Japan", 85.34f, 2.312f, 5, 7, 4);
        System.out.println("Название модели = " + secondJaeger.getModelName());
        System.out.println("Марка = " + secondJaeger.getMark());
        System.out.println("Производитель = " + secondJaeger.getOrigin());
        System.out.println("Высота = " + secondJaeger.getHeight());
        System.out.println("Масса = " + secondJaeger.getWeight());
        System.out.println("Скорость = " + secondJaeger.getSpeed());
        System.out.println("Сила = " + secondJaeger.getStrength());
        System.out.println("Броня = " + secondJaeger.getArmor());
        secondJaeger.move();
        secondJaeger.drift();
        secondJaeger.useVortexCannon();
        System.out.println("Результат поиска кайдзю: " + secondJaeger.scanKaiju());
    }
}