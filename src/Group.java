import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Character> characters = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void moveTo(int[] newPosition) {
        for (Character character : characters) {
            character.moveTo(newPosition);
        }
        System.out.println(name + " moved to " + newPosition[0] + ", " + newPosition[1]);
    }
}
