public abstract class Transit {
    private int price;
    private int travelTime;
    private double coefficentOfPrice;
    private String destination;
    private String initialLocation;

    public Transit(int price, int travelTime, String destination, String initialLocation,double coefficentOfPrice) {
        this.price = price;
        this.coefficentOfPrice = coefficentOfPrice;
        this.travelTime = travelTime;
        this.destination = destination;
        this.initialLocation = initialLocation;
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

}
