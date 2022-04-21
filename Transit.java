import java.util.ArrayList;

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
        seats = new ArrayList<>();
        generateSeats(20);
        // priint();
        

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

    public ArrayList<Seat> generateSeats(int maxSeatCapacity) {
        char letter = 'A';
        for (int i = 0; i < maxSeatCapacity;i+=4) {
            for (int j = 0; j <4; j++) {
                String location = String.valueOf(letter) + (j + 1);
                    seats.add(new Seat(location));
            }
            letter++;
        }
        return seats;
    }
    
    
}
