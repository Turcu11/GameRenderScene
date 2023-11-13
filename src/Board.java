import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int width;
    private int length;
    private List<House> houses = new ArrayList<>();
    private Map<String, HouseFactory> houseFactories = new HashMap<>();
    private List<Character> characters = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private Map<String, CharacterFactory> characterFactories = new HashMap<>();

    public Board(int width, int length) {
        this.width = width;
        this.length = length;
        initializeHouseFactories();
        initializeCharacterFactories();
    }

    private void initializeHouseFactories() {
        houseFactories.put("European", new EuropeanHouseFactory());
        houseFactories.put("Asian", new AsianHouseFactory());
        houseFactories.put("African", new AfricanHouseFactory());
    }
    private void initializeCharacterFactories() {
        characterFactories.put("Human", new HumanFactory());
        characterFactories.put("Elf", new ElfFactory());
    }

    public void addHouse(String houseType, int[] position, int[] size) {
        HouseFactory houseFactory = houseFactories.get(houseType);
        if (houseFactory != null) {
            if (isPositionValid(position, size)) {
                House house = houseFactory.createHouse(position, size);
                houses.add(house);
//                System.out.println("Added " + houseType + " house at (" + position[0] + ", " + position[1] + ")");
            } else {
                System.out.println("Invalid position for " + houseType + " house at (" + position[0] + ", " + position[1] + ")");
            }
        } else {
            System.out.println("Invalid house type: " + houseType);
        }
    }

    public boolean isPositionValid(int[] position, int[] size) {
        if (position[0] < 0 || position[1] < 0 || position[0] + size[0] > width || position[1] + size[1] > length) {
            return false;
        }

        for (House house : houses) {
            if (position[0] < house.position[0] + house.size[0] && position[0] + size[0] > house.position[0] &&
                    position[1] < house.position[1] + house.size[1] && position[1] + size[1] > house.position[1]) {
                return false;
            }
        }

        return true;
    }

    public void render() {
        for (House house : houses) {
            System.out.println("House at (" + house.position[0] + ", " + house.position[1] + ") with size (" +
                    house.size[0] + ", " + house.size[1] + "), made of " + house.material + " with " + house.roofType);
        }
    }

    //from here is character related

    public void addCharacter(String characterType, String name, int age, int[] position, int[] size, String abilities) {
        CharacterFactory characterFactory = characterFactories.get(characterType);
        if (characterFactory != null) {
            Character character = characterFactory.createCharacter(name, age, position, size, abilities);
            characters.add(character);
            System.out.println("Added " + characterType + " character: " + name);
        } else {
            System.out.println("Invalid character type: " + characterType);
        }
    }

    public void addGroup(String groupName) {
        Group group = new Group(groupName);
        groups.add(group);
        System.out.println("Added group: " + groupName);
    }

    public void addToGroup(String groupName, String characterName) {
        Group group = findGroup(groupName);
        Character character = findCharacter(characterName);

        if (group != null && character != null) {
            group.addCharacter(character);
            System.out.println("Added " + characterName + " to group: " + groupName);
        } else {
            System.out.println("Group or character not found.");
        }
    }

    public Group findGroup(String groupName) {
        for (Group group : groups) {
            if (group.getName().equals(groupName)) {
                return group;
            }
        }
        return null;
    }

    private Character findCharacter(String characterName) {
        for (Character character : characters) {
            if (character.getName().equals(characterName)) {
                return character;
            }
        }
        return null;
    }

}