import java.util.ArrayList;

public abstract class Transit implements Info {
    private String type;
    private double price;
    private double travelTime;
    private String destination;
    private String initialLocation;
    private double coefficentOfPrice;
    private int seatCapacity;
    private ArrayList<Seat> seats;
    private ArrayList<Boolean> updatedSeatStatus;

    public Transit(GenericInput[] inputs) throws Exception {
        for (GenericInput input : inputs) {
            switch (input.getProperyName()) {
                case "travelTime":
                    setTravelTime((int) input.getValue());
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
        }
        generateSeats();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Transit(int travelTime, String destination, String initialLocation, double coefficentOfPrice,
            int seatCapacity, ArrayList<Boolean> updatedSeatStatus) throws Exception {
        setTravelTime(travelTime);
        this.destination = destination;
        this.initialLocation = initialLocation;
        this.coefficentOfPrice = coefficentOfPrice;
        this.seatCapacity = seatCapacity;
        this.updatedSeatStatus = updatedSeatStatus;

        generateSeats();
    }

    public Transit(String[] line) throws Exception {
        int timeSelection;
        switch (line[2]) {
            case "Sabah":
                timeSelection = 1;
                break;
            case "Ogle":
                timeSelection = 2;
                break;
            case "Aksam":
                timeSelection = 3;
                break;
            case "Gece":
                timeSelection = 4;
                break;
            default:
                timeSelection = 0;
                break;
        }
        ArrayList<Boolean> updatedSeatStatus = new ArrayList<>();
        for (int i = 7; i < line.length; i++) {
            updatedSeatStatus.add(Boolean.parseBoolean(line[i]));
        }

        setTravelTime(timeSelection);
        this.destination = line[3];
        this.initialLocation = line[4];
        this.coefficentOfPrice = Double.parseDouble(line[5]);
        this.seatCapacity = Integer.parseInt(line[6]);
        this.updatedSeatStatus = updatedSeatStatus;

        generateSeats();
    }

    public ArrayList<Boolean> getUpdatedSeatStatus() {
        return updatedSeatStatus;
    }

    public void setUpdatedSeatStatus(ArrayList<Boolean> updatedSeatStatus) {
        this.updatedSeatStatus = updatedSeatStatus;
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
            return "Ogle";
        } else if (travelTime == 2.5) {
            return "Aksam";
        } else if (travelTime == 3) {
            return "Gece";
        } else {
            throw new Exception("bulunamadı!");
        }
    }

    public void setTravelTime(int travelTime) throws Exception {
        switch (travelTime) {
            case 1:
                this.travelTime = 1.5;
                break;
            case 2:
                this.travelTime = 2;
                break;
            case 3:
                this.travelTime = 2.5;
                break;
            case 4:
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
        for (int i = 0, j = 0; j < 4 && i < seatCapacity; i++, j++) {
            String location = String.valueOf(letter) + (j + 1);
            seats.add(new Seat(location));
            if (j == 3) {
                letter++;
                j = -1;
            }
        }

        if (updatedSeatStatus != null) {
            for (int i = 0; i < seats.size(); i++) {
                seats.get(i).setIsEmpty(updatedSeatStatus.get(i));
            }
        }
    }

    public String shemaOfSeats() {
        String shema = "\n--------------------------\n";
        for (Seat seat : this.seats) {
            shema += seat.getLocation() + " Status: " + (seat.getIsEmpty() ? "Free" : "Occupied") + "\n";
        }
        return shema;
    }

    @Override
    public String toString() {
        try {
            String allSeatsStatus = "";
            for (Seat seat : seats) {
                allSeatsStatus += ", " + seat.getIsEmpty();
            }
            return getClass().getSimpleName() + ", " + ((int) (100 * price) / 100.0) + ", " + getTravelTime() + ", "
                    + destination + ", " + initialLocation + ", " + coefficentOfPrice + ", " + seatCapacity
                    + allSeatsStatus + "\n";
        } catch (Exception e) {
            return "";
        }
    }

}