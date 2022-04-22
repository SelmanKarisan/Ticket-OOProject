import java.util.ArrayList;

public abstract class Transit implements Info {
    private double price;
    private double travelTime;
    private String destination;
    private String initialLocation;
    private double coefficentOfPrice;
    private int maxSeatCapacity;
    private ArrayList<Seat> seats;

    public Transit(double price, String travelTime2, String destination, String initialLocation, double coefficentOfPrice,
            int maxSeatCapacity) throws Exception {
        this.price = price;
        setTravelTime(travelTime2);
        this.destination = destination;
        this.initialLocation = initialLocation;
        this.coefficentOfPrice = coefficentOfPrice;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getTravelTimeValue(){
        return this.travelTime;
    }
    public String getTravelTime() throws Exception {
        if (travelTime == 1.5) {
            return "Sabah";
        } else if (travelTime == 2) {
            return "Öğle";
        } else if (travelTime == 2.5) {
            return "Akşam";
        } else if (travelTime == 3) {
            return "Gece";
        } else {
            throw new Exception("bulunamadı!");
        }
    }

    public void setTravelTime(String travelTime) throws Exception {
        switch (travelTime) {
            case "Sabah":
                this.travelTime = 1.5;
                break;
            case "Öğle":
                this.travelTime = 2;
                break;
            case "Akşam":
                this.travelTime = 2.5;
                break;
            case "Gece":
                this.travelTime = 3;
                break;
            default:
                throw new Exception("bulunamadı!");
        }
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

    public String shemaOfSeats() {
        String shema = "--------------------------\n";
        for (Seat seat : seats) {
            shema += seat.getLocation() + " Status: " + (seat.getIsEmpty() ? "Free" : "Occupied") + "\n";
            shema += "--------------------------\n";
        }
        return shema;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", " + price + ", " + travelTime + ", " + destination + ", "
                + initialLocation + ", " + coefficentOfPrice + ", " + maxSeatCapacity;
    }

}
