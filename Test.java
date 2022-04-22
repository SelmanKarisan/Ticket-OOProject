import java.util.Scanner;

public class Test {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

        if (selection == 2) {
            System.out.print("Hangi araç için sefer eklemek istiyorsunuz(1, 2 ya da 3'ü tuşlayın)");
            System.out.println("1-Uçak");
            System.out.println("2-Tren");
            System.out.println("3-Otobüs");
            int transitSelection = scanner.nextInt();
            switch (transitSelection) {
                case 1:
                    Airplane airplane = new Airplane(price, travelTime, destination, initialLocation, coefficentOfPrice,
                            maxSeatCapacity);
                    break;
                case 2:
                    Train train = new Train(price, travelTime, destination, initialLocation, coefficentOfPrice,
                            maxSeatCapacity);
                    break;
                case 3:
                    Bus bus = new Bus(price, travelTime, destination, initialLocation, coefficentOfPrice,
                            maxSeatCapacity);
                    break;
            
                default:
                    break;
            }
        }
        
    }
}
