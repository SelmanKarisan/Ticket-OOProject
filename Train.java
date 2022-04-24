public class Train extends Transit {

    public Train(double price, String travelTime, String destination, String initialLocation, double coefficentOfPrice,
            int seatCapacity) throws Exception {
        super(price, travelTime, destination, initialLocation, coefficentOfPrice, seatCapacity);
        super.generateSeats();
        calculatePrice();
    }

    @Override
    public void calculatePrice() {
        setPrice(getPrice() * getCoefficentOfPrice() * getTravelTimeValue());
    }

    @Override
    public void createSeat() {

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
