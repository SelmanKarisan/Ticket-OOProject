public class Train extends Transit{

    public Train(int price, int travelTime, String destination, String initialLocation, double coefficentOfPrice) {
        super(price, travelTime, destination, initialLocation, coefficentOfPrice);
    }

    @Override
    public void calculatePrice() {
        
    }

    @Override
    public void createSeat() {
        Seat seat = new Seat("A1");
    }
    
}
