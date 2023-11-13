public class HumanFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name, int age, int[] position, int[] size, String abilities) {
        return new Character(name, age, position, size, abilities);
    }
}
