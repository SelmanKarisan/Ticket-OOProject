import java.util.ArrayList;

public abstract class Transit implements Info {
    private int price;
    private int travelTime;
    private double coefficentOfPrice;
    private String destination;
    private String initialLocation;
    private int maxSeatCapacity;
    private ArrayList<Seat> seats;

    public Transit(int price, int travelTime, String destination, String initialLocation, double coefficentOfPrice,
            int maxSeatCapacity) {
        this.price = price;
        this.coefficentOfPrice = coefficentOfPrice;
        this.travelTime = travelTime;
        this.destination = destination;
        this.initialLocation = initialLocation;
        this.maxSeatCapacity = maxSeatCapacity;
        seats = new ArrayList<>();
        generateSeats(20);
        // priint();

    }

    public int getMaxSeatCapacity() {
        return maxSeatCapacity;
    }

    public void setMaxSeatCapacity(int maxSeatCapacity) {
        this.maxSeatCapacity = maxSeatCapacity;
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
        for (int i = 0; i < maxSeatCapacity; i += 4) {
            for (int j = 0; j < 4; j++) {
                String location = String.valueOf(letter) + (j + 1);
                seats.add(new Seat(location));
            }
            letter++;
        }
        return seats;
    }

    public void printShemaOfSeats() {
        System.out.println("--------------------------");
        for (Seat seat : seats) {
            System.out.print(seat.getLocation() + " Status: " + (seat.getIsEmpty() ? "Free" : "Occupied") + "\n");
            System.out.println("--------------------------");
        }
    }
    @Override
    public String toString() {
        return "";
    }

}
