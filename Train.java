public class Train extends Transit {

    public Train(int price, String travelTime, String destination, String initialLocation, double coefficentOfPrice,
            int maxSeatCapacity) throws Exception {
        super(price, travelTime, destination, initialLocation, coefficentOfPrice, maxSeatCapacity);
        super.generateSeats(maxSeatCapacity);
    }

    @Override
    public void calculatePrice() {

    }

    @Override
    public void createSeat() {
    }

}
