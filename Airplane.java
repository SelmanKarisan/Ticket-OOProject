public class Airplane extends Transit {
    public final static GenericInput[] INPUTS = new GenericInput[] {
            new GenericInput("price", "Enter price", Double.class.getSimpleName(), null),
            new GenericInput("travelTime", "Enter travelTime", String.class.getSimpleName(), null),
            new GenericInput("destination", "Enter destination", String.class.getSimpleName(), null),
            new GenericInput("initialLocation", "Enter initialLocation", String.class.getSimpleName(), null),
            new GenericInput("coefficentOfPrice", "Enter coefficentOfPrice", Double.class.getSimpleName(), null),
            new GenericInput("seatCapacity", "Enter seatCapacity", Integer.class.getSimpleName(), null)
    };

    public Airplane(GenericInput[] inputs) throws Exception {
        super(inputs);
    }

    public Airplane(double price, String travelTime, String destination, String initialLocation,
            double coefficentOfPrice, int seatCapacity) throws Exception {
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
