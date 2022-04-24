import java.util.ArrayList;

public abstract class Transit implements Info {
    private double price;
    private double travelTime;
    private String destination;
    private String initialLocation;
    private double coefficentOfPrice;
    private int seatCapacity;
    private ArrayList<Seat> seats;

    public final static GenericInput[] INPUTS = new GenericInput[] {
            new GenericInput("price", "Enter price: ", Double.class.getSimpleName(), null),
            new GenericInput("travelTime", "Enter travelTime: ", String.class.getSimpleName(), null),
            new GenericInput("destination", "Enter destination: ", String.class.getSimpleName(), null),
            new GenericInput("initialLocation", "Enter initialLocation: ", String.class.getSimpleName(), null),
            new GenericInput("coefficentOfPrice", "Enter coefficentOfPrice: ", Double.class.getSimpleName(), null),
            new GenericInput("seatCapacity", "Enter seatCapacity: ", Integer.class.getSimpleName(), null)
    };

    public Transit(GenericInput[] inputs) throws Exception {
        for (GenericInput input : inputs) {
            switch (input.getProperyName()) {
                case "price":
                    this.price = (double) input.getValue();
                    break;
                case "travelTime":
                    setTravelTime((String) input.getValue());
                    break;
                case "destination":
                    this.destination = (String) input.getValue();
                    break;
                case "initialLocation":
                    this.initialLocation = (String) input.getValue();
                    break;
                case "coefficentOfPrice":
                    this.coefficentOfPrice = (double) input.getValue();
                    break;
                case "seatCapacity":
                    this.seatCapacity = (int) input.getValue();
                    break;
            }
            generateSeats();
        }
    }

    public Transit(double price, String travelTime, String destination, String initialLocation,
            double coefficentOfPrice,
            int seatCapacity) throws Exception {
        this.price = price;
        setTravelTime(travelTime);
        this.destination = destination;
        this.initialLocation = initialLocation;
        this.coefficentOfPrice = coefficentOfPrice;
        this.seatCapacity = seatCapacity;
        generateSeats();
    }

    public int getseatCapacity() {
        return seatCapacity;
    }

    public void setseatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
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

    public double getTravelTimeValue() {
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

    public void generateSeats() {
        seats = new ArrayList<>();
        char letter = 'A';
        for (int i = 0; i < seatCapacity; i += 4) {
            for (int j = 0; j < 4; j++) {
                String location = String.valueOf(letter) + (j + 1);
                seats.add(new Seat(location));
            }
            letter++;
        }
    }

    public String shemaOfSeats() {
        String shema = "\n--------------------------\n";
        for (Seat seat : seats) {
            shema += seat.getLocation() + " Status: " + (seat.getIsEmpty() ? "Free" : "Occupied") + "\n";
        }
        return shema;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", " + price + ", " + travelTime + ", " + destination + ", "
                + initialLocation + ", " + coefficentOfPrice + ", " + seatCapacity;
    }

}
