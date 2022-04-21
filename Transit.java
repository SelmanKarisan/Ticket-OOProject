<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> 70132a75780fdd11e0404b2b0d3a235cb05bacae
public abstract class Transit implements Info {
    private int price;
    private int travelTime;
    private double coefficentOfPrice;
    private String destination;
    private String initialLocation;
    private ArrayList<Seat> seats;

    public Transit(int price, int travelTime, String destination, String initialLocation, double coefficentOfPrice) {
        this.price = price;
        this.coefficentOfPrice = coefficentOfPrice;
        this.travelTime = travelTime;
        this.destination = destination;
        this.initialLocation = initialLocation;
        setSeats(new ArrayList<>());

    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public double getCoefficentOfPrice() {
        return coefficentOfPrice;
    }

    public void setCoefficentOfPrice(double coefficentOfPrice) {
        this.coefficentOfPrice = coefficentOfPrice;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTravelTime() {
        return this.travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getInitialLocation() {
        return this.initialLocation;
    }

    public void setInitialLocation(String initialLocation) {
        this.initialLocation = initialLocation;
    }

<<<<<<< HEAD
    public ArrayList<Seat> generateSeats(int maxSeatCapacity) {
        String letter = "A";
        for (int i = 0; i < maxSeatCapacity;) {
            String location = letter + (i + 1);
            if (i % 4 == 0) {
                i = 0;
                location = 
                seats.add(new Seat(location));
            }
        }
    }
=======
    

>>>>>>> 70132a75780fdd11e0404b2b0d3a235cb05bacae
}
