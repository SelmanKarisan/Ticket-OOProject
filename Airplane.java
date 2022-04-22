public class Airplane extends Transit {

    public Airplane(int price, String travelTime, String destination, String initialLocation, double coefficentOfPrice,
            int maxSeatCapacity) throws Exception {
        super(price, travelTime, destination, initialLocation, coefficentOfPrice, maxSeatCapacity);
        super.generateSeats(maxSeatCapacity);
        calculatePrice();
    }

    @Override
    public void calculatePrice() {
    }

    @Override
    public void createSeat() {

    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString();
    }

}   
