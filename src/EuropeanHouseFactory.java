public class EuropeanHouseFactory implements HouseFactory{
    @Override
    public House createHouse(int[] position, int[] size) {
        return new House(position, size, "Concrete", "Traditional European Roof");
    }
}
