public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.gender = "Кабель";
        wolf.name = "Ява";
        wolf.color = "Серый";
        wolf.weight = 39.5f;
        wolf.age = 9;

        System.out.println("Перед нами волк по кличке " + wolf.name + ", это " + wolf.gender);
        System.out.println("Посмотрите на его красивый " + wolf.color + " цвет");
        System.out.println("Это молодой и грозный " + wolf.age + "-летний волк весом " + wolf.weight + " килограмм");
        System.out.println("\nЧто же делает сейчас этот волк? А он сейчас:\n");

        wolf.move();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}