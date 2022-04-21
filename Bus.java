import java.util.ArrayList;

public class Bus extends Transit{

    public Bus(int price, int travelTime, String destination, String initialLocation, double coefficentOfPrice) {
        super(price, travelTime, destination, initialLocation, coefficentOfPrice);
        
    }
    ArrayList<Seat> seats=new ArrayList<>();

    @Override
    public void calculatePrice() {
        // TODO Auto-generated methodstub
        
        
    }

    @Override
    public void createSeat() {
        // TODO Auto-generated method stub
        Seat koltuklar =new Seat("A1");
        


    }

}
