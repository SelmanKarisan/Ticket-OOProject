public class Airplane extends Transit {

    public Airplane(int price, int travelTime, String destination, String initialLocation, double coefficentOfPrice,
            int maxSeatCapacity) {
        super(price, travelTime, destination, initialLocation, coefficentOfPrice, maxSeatCapacity);
        super.generateSeats(maxSeatCapacity);
    }

    @Override
    public void calculatePrice() {

    }

    @Override
    public void createSeat() {

    }
    @Override
    public String toString() {
        return super.toString();
    }

}   
