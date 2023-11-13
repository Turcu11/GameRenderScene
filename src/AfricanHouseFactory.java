class AfricanHouseFactory implements HouseFactory {
    @Override
    public House createHouse(int[] position, int[] size) {
        return new House(position, size, "Wail and Cane", "African Roof");
    }
}