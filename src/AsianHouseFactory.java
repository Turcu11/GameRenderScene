class AsianHouseFactory implements HouseFactory {
    @Override
    public House createHouse(int[] position, int[] size) {
        return new House(position, size, "Bamboo", "Asian Roof");
    }
}