public class Character {
    private String name;
    private int age;
    private int[] position;
    private int[] size;
    private String abilities;

    public Character(String name, int age, int[] position, int[] size, String abilities) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.size = size;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public void moveTo(int[] newPosition) {
        this.position = newPosition;
        System.out.println(name + " moved to " + newPosition[0] + ", " + newPosition[1]);
    }
}
