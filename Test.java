import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private static Scanner scanner;
    private final static String adminUsername = "admin";
    private final static String adminPassword = "1883";

    public static GenericInput[] getInput(GenericInput[] inputs) {
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
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
                System.out.print("Varış noktası giriniz:");
                String destination = scanner.next().toLowerCase();
                System.out.print("Başlangıç noktası giriniz:");
                String initialLocation = scanner.next().toLowerCase();
                System.out.print("Seyehat etmek istediğiniz aracı seçiniz:\n1-Uçak\n2-Tren\n3-Otobüs\n");
                int selectionForVehicle = scanner.nextInt();
                String vehicleName;
                switch (selectionForVehicle) {
                    case 1:
                        vehicleName = "Airplane";
                        break;
                    case 2:
                        vehicleName = "Train";
                        break;
                    case 3:
                        vehicleName = "Bus";
                        break;
                    default:
                        throw new Exception("bulunamadı");
                }

                scanner = new Scanner(new File("./TravelPlan.txt"));
                readFileAndCreateObject("./TravelPlan.txt");
                while (scanner.hasNextLine()) {
                    String[] line = scanner.nextLine().split(", ");
                    if (vehicleName.equals(line[0]) && destination.equals(line[3]) && initialLocation.equals(line[4])) {
                        switch (vehicleName) {
                            case "Airplane": {
                                writeToFile("./SeatSchema.txt",
                                        "Uçak, Ucret: " + line[1] + Airplane.shemaOfSeats() + "\n", false);
                                System.out.println("Uçak, Ucret: " + line[1] + Airplane.shemaOfSeats() + "\n");
                                break;
                            }
                            case "Train": {
                                writeToFile("./SeatSchema.txt", "Tren, Ucret: " + line[1] + Train.shemaOfSeats() + "\n",
                                        false);
                                System.out.println("Tren, Ucret: " + line[1] + Train.shemaOfSeats() + "\n");
                                break;
                            }
                            case "Bus": {
                                writeToFile("./SeatSchema.txt", "Otobüs, Ucret: " + line[1] + Bus.shemaOfSeats() + "\n",
                                        false);
                                System.out.println("Otobüs, Ucret: " + line[1] + Bus.shemaOfSeats() + "\n");
                                break;
                            }
                        }
                    }
                }
                scanner.close();
                scanner = new Scanner(System.in);
                System.out.print("Koltuk seçiniz:");
                String seatNumber = scanner.next().toUpperCase();
                scanner.close();

                scanner = new Scanner(new File("./SeatSchema.txt"));
                int counterForSeatNumber = 0;
                // finding place
                while (scanner.hasNextLine()) {
                    counterForSeatNumber++;
                    String[] seatLine = scanner.nextLine().split(" ");
                    if (counterForSeatNumber < 3) {
                        continue;
                    }
                    if (seatNumber.equals(seatLine[0]) && seatLine[2].equals("Free")) {
                        System.out.println("Koltuk seçilmiştir");
                        break;
                    }
                    
                    if (seatNumber.equals(seatLine[0]) && !seatLine[2].equals("Free")) {
                        System.out.println("Seçtiğiniz koltuk uygun değil");
                        break;
                    }
                        
                }
                counterForSeatNumber -= 2;
                scanner.close();

                // updateSeatStatus(counterForSeatNumber);
                scanner = new Scanner(new File("./TravelPlan.txt"));
                String lines = "";
                while (scanner.hasNextLine()) {

                    String[] line = scanner.nextLine().split(", ");
                    if (line[0].equals("")) {
                        continue;
                    }
                    if (vehicleName.equals(line[0]) && destination.equals(line[3]) && initialLocation.equals(line[4])) {
                        line[6 + counterForSeatNumber] = "false";
                        lines += String.join(", ", line);
                    }
                }
                writeToFile("./TravelPlan.txt", lines, false);
                scanner.close();
                break;
            case 2:
                // kullanıcı girişi
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

                // kullancı girişi sonrası
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
                break;
            default:
                throw new Exception("invalid selection");
        }
    }

    private static void readFileAndCreateObject(String filePath) throws Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            int timeSelection = 0;

            String[] line = scanner.nextLine().split(", ");
            if (line[0].equals("")) {
                continue;
            }
            if (line[2].equals("Sabah")) {
                timeSelection = 1;
            } else if (line[2].equals("Ogle")) {
                timeSelection = 2;
            } else if (line[2].equals("Aksam")) {
                timeSelection = 3;
            } else if (line[2].equals("Gece")) {
                timeSelection = 4;
            }
            ArrayList<Boolean> updatedSeatStatus = new ArrayList<>();
            for (int i = 7; i < line.length; i++) {
                if (line[i].equals("true")) {
                    updatedSeatStatus.add(true);
                } else {
                    updatedSeatStatus.add(false);
                }

            }
            switch (line[0]) {
                case "Airplane":
                    new Airplane(timeSelection, line[3], line[4], Double.parseDouble(line[5]),
                            Integer.parseInt(line[6]), updatedSeatStatus);
                    break;
                case "Train":
                    new Train(timeSelection, line[3], line[4], Double.parseDouble(line[5]), Integer.parseInt(line[6]),
                            updatedSeatStatus);
                    break;
                case "Bus":
                    new Bus(timeSelection, line[3], line[4], Double.parseDouble(line[5]), Integer.parseInt(line[6]),
                            updatedSeatStatus);
                    break;
            }
        }
        scanner.close();

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
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file, append);
        fileWriter.write(value + "\n");
        fileWriter.close();
    }
}