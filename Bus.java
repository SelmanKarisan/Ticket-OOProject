import java.util.ArrayList;

public class Bus extends Transit{

    public Bus(int price, int travelTime, String destination, String initialLocation, double coefficentOfPrice) {
        super(price, travelTime, destination, initialLocation, coefficentOfPrice);
        
    }
<<<<<<< HEAD

    @Override
    public void calculatePrice() {
=======
    ArrayList<Seat> seats=new ArrayList<>();

    @Override
    public void calculatePrice() {
        // TODO Auto-generated methodstub
        
>>>>>>> 70132a75780fdd11e0404b2b0d3a235cb05bacae
        
    }

    @Override
    public void createSeat() {
<<<<<<< HEAD
        
=======
        // TODO Auto-generated method stub
        Seat koltuklar =new Seat("A1");
        


>>>>>>> 70132a75780fdd11e0404b2b0d3a235cb05bacae
    }

}
