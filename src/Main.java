public class Main {
    public static void main(String[] args) {
        Board board = new Board(100, 100);

        board.addHouse("European", new int[]{10, 10}, new int[]{5, 5});
        board.addHouse("Asian", new int[]{30, 30}, new int[]{7, 7});

        board.addCharacter("Human", "John", 25, new int[]{0, 0}, new int[]{1, 1}, "Strength, Agility");
        board.addCharacter("Elf", "Legolas", 150, new int[]{2, 2}, new int[]{1, 1}, "Archery, Stealth");

        board.addGroup("Army");

        board.addToGroup("Army", "John");
        board.addToGroup("Army", "Legolas");

        int[] newPosition = {5, 5};
        board.findGroup("Army").moveTo(newPosition);

        board.render();
    }
}