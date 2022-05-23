import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private static Scanner scanner;
    private final static String adminUsername = "admin";
    private final static String adminPassword = "1883";

    public static GenericInput[] getInput(GenericInput[] inputs) {
        for (GenericInput input : inputs) {
            System.out.print(input.getMessage());
            if (input.getType().equals(String.class.getSimpleName())) {
                input.setValue(scanner.next());
            } else if (input.getType().equals(Double.class.getSimpleName())) {
                input.setValue(scanner.nextDouble());
            } else if (input.getType().equals(Integer.class.getSimpleName())) {
                input.setValue(scanner.nextInt());
            }
        }
        return inputs;
    }

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("Marmara Turizm'e Hoşgeldiniz");
        System.out.println("Bilet almak için: 1\nSeyehat oluşturmak için: 2 ");
        int selection = scanner.nextInt();
        // Bilet alma sistemi için
        switch (selection) {
            case 1:
                buyTicket();
                break;
            case 2:
                // kullanıcı girişi
                loginAdmin();
                // Sefer oluşturma
                createTravel();
                break;
            default:
                throw new Exception("invalid selection");
        }
    }

    private static void createTravel() throws Exception {
        System.out.println("Hangi araç için sefer eklemek istiyorsunuz\n1-Uçak\n2-Tren\n3-Otobüs");
        int transitSelection = scanner.nextInt();
        switch (transitSelection) {
            case 1:
                Transit airplane = new Airplane(getInput(Airplane.INPUTS));
                writeToFile("./TravelPlan.txt", airplane.toString(), true);
                break;
            case 2:
                Transit train = new Train(getInput(Train.INPUTS));
                writeToFile("./TravelPlan.txt", train.toString(), true);
                break;
            case 3:
                Transit bus = new Bus(getInput(Bus.INPUTS));
                writeToFile("./TravelPlan.txt", bus.toString(), true);
                break;
            default:
                throw new Exception("bulunamadı!");
        }
    }

    private static void loginAdmin() {
        Boolean isAdminLogged = false;
        do {
            System.out.print("Kullanıcı adını giriniz:");
            String userName = scanner.next();
            System.out.print("Şifrenizi giriniz:");
            String password = scanner.next();
            if (userName.equals(adminUsername) && password.equals(adminPassword)) {
                isAdminLogged = true;
                break;
            }
            System.out.println("Kullanıcı adınız veya şifreniz yanlış lütfen tekrar deneyiniz");
        } while (!isAdminLogged);
    }

    private static void buyTicket() throws Exception, FileNotFoundException {
        System.out.print("Varış noktası giriniz:");
        String destination = scanner.next().toLowerCase();
        System.out.print("Başlangıç noktası giriniz:");
        String initialLocation = scanner.next().toLowerCase();
        System.out.print("Seyehat etmek istediğiniz aracı seçiniz:\n1-Uçak\n2-Tren\n3-Otobüs\n");
        int selectionForVehicle = scanner.nextInt();
        String vehicleType;
        switch (selectionForVehicle) {
            case 1:
                vehicleType = "Airplane";
                break;
            case 2:
                vehicleType = "Train";
                break;
            case 3:
                vehicleType = "Bus";
                break;
            default:
                throw new Exception("bulunamadı");
        }

        ArrayList<Transit> transits = getTransitsFromFile("./TravelPlan.txt");
        Transit selectedTransit = null;
        for (Transit transit : transits) {
            if (transit.getType() == vehicleType && destination.equals(transit.getDestination())
                    && initialLocation.equals(transit.getInitialLocation())) {
                selectedTransit = transit;
            }
        }
        if (selectedTransit == null) {
            throw new Exception("bulunamadı");
        }

        System.out.println(selectedTransit.getType() + ", Price: " + selectedTransit.getPrice()
                + selectedTransit.shemaOfSeats());

        System.out.print("\nKoltuk seçiniz:");
        String seatNumber = scanner.next().toUpperCase();
        scanner.close();

        boolean isExist = false;
        for (Seat seat : selectedTransit.getSeats()) {
            if (seatNumber.equals(seat.getLocation())) {
                isExist = true;
            }
        }
        if (isExist) {
            for (Seat seat : selectedTransit.getSeats()) {
                if (seat.getLocation().equals(seatNumber)) {
                    if (seat.getIsEmpty()) {
                        seat.setIsEmpty(false);
                        System.out.println("Koltuk seçilmiştir");
                        break;
                    }
                    System.out.println("Seçtiğiniz koltuk uygun değil!");
                    break;
                }
            }
        } else {
            System.out.println("Böyle bir koltuk yok!");
        }

        updateTravels(transits);
        // Todo: setTravelsToFile

        // // updateSeatStatus(counterForSeatNumber);
        // scanner = new Scanner(new File("./TravelPlan.txt"));
        // String lines = "";
        // while (scanner.hasNextLine()) {

        // String[] line = scanner.nextLine().split(", ");
        // if (line[0].equals("")) {
        // continue;
        // }
        // if (vehicleType.equals(line[0]) && destination.equals(line[3]) &&
        // initialLocation.equals(line[4])) {
        // line[6 + counterForSeatNumber] = "false";
        // }
        // lines += (String.join(", ", line) + "\n");
        // }
        // writeToFile("./TravelPlan.txt", lines, false);
        // scanner.close();
    }

    private static Transit createTransit(String type, String[] props) throws Exception {
        switch (type) {
            case "Airplane":
                return new Airplane(props);
            case "Train":
                return new Train(props);
            case "Bus":
                return new Bus(props);
            default:
                throw new Exception("invalid transit type");
        }
    }

    private static ArrayList<Transit> getTransitsFromFile(String filePath) throws Exception {
        Scanner scanner = new Scanner(new File(filePath));
        ArrayList<Transit> transits = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(", ");
            if (line[0].equals("")) {
                continue;
            }
            transits.add(createTransit(line[0], line));
        }
        scanner.close();
        return transits;
    }

    // private static ArrayList<Boolean> updateSeatStatus(int index) {
    // ArrayList<Boolean> updatedSeatStatus = new ArrayList<>();
    // Transit.seats.get(index).setIsEmpty(false);
    // for (Seat seat : Transit.seats) {
    // updatedSeatStatus.add(seat.getIsEmpty());
    // }
    // return updatedSeatStatus;
    // }

    private static void writeToFile(String filePath, String value, boolean append) throws Exception {
        FileWriter fileWriter = new FileWriter(new File(filePath), append);
        fileWriter.write(value);
        fileWriter.close();
    }

    private static void updateTravels(ArrayList<Transit> transits) throws Exception {
        // remove all
        writeToFile("./TravelPlan.txt", "", false);
        // append all
        for (Transit transit : transits) {
            writeToFile("./TravelPlan.txt", transit.toString(), true);
        }
    }
}