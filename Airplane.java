import java.util.ArrayList;

public class Airplane extends Transit {
    public final static GenericInput[] INPUTS = new GenericInput[] {
            new GenericInput("travelTime", "Yolculuk zamanını seçin\n1-Sabah\n2-Öğle\n3-Akşam\n4-Gece\n",
                    Integer.class.getSimpleName(), null),
            new GenericInput("destination", "Varış konumunu seçin:", String.class.getSimpleName(), null),
            new GenericInput("initialLocation", "Kalkış konumunu seçin:", String.class.getSimpleName(), null),
            new GenericInput("coefficentOfPrice", "Pahalılık katsayısını girin:", Double.class.getSimpleName(), null),
            new GenericInput("seatCapacity", "Koltuk kapasitesini girin:", Integer.class.getSimpleName(), null)
    };

    public Airplane(GenericInput[] inputs) throws Exception {
        super(inputs);
        this.setType("Airplane");
        calculatePrice();
    }

    public Airplane(int travelTime, String destination, String initialLocation,
            double coefficentOfPrice, int seatCapacity, ArrayList<Boolean> updatedSeatStatus) throws Exception {
        super(travelTime, destination, initialLocation, coefficentOfPrice, seatCapacity, updatedSeatStatus);
        this.setType("Airplane");
        calculatePrice();
    }

    public Airplane(String[] line) throws Exception {
        super(line);
        this.setType("Airplane");
        calculatePrice();
    }

    @Override
    public void calculatePrice() {
        setPrice(getCoefficentOfPrice() * getTravelTimeValue());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
