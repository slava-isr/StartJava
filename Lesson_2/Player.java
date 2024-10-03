public class Player {

    private String name;
    private int number;
    private static int playerId = 0;

    public Player(String name) {
        playerId++;
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.isEmpty() ? "Игрок-" + playerId : name;
        System.out.println("Вам будет присвоено имя \"" + this.name + "\"");
    }

    public void setNumber(int number) {
        this.number = number;
    }
}