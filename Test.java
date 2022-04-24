import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Test {
    private static Scanner scanner;
    private static ArrayList<String> planContent;
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

        // System.out.print("Varış yerini giriniz:");
        // var destination = scanner.next();
        // System.out.print("Başlangıç yeri seçiniz:");
        // var initialLocation = scanner.next();
        // System.out.println("Seyehat edilecek zamanı
        // seçiniz\n1-Sabah\n2-Öğle\n3-Akşam\n4-Gece");
        // var selectionForTravelTime = scanner.nextInt();
        // String travelTime;
        // switch (selectionForTravelTime) {
        // case 1:
        // travelTime = "Sabah";
        // break;
        // case 2:
        // travelTime = "Öğle";
        // break;
        // case 3:
        // travelTime = "Akşam";
        // break;
        // case 4:
        // travelTime = "Gece";
        // break;
        // default:
        // throw new IllegalArgumentException("Seyehat edilecek zamanı yanlış girildi");
        // }
        // System.out.print("Seyehat fiyatını giriniz:");
        // var price = scanner.nextDouble();
        // System.out.print("Seyehat pahalılık katsayısını giriniz:");
        // var coeff = scanner.nextDouble();
        // System.out.print("Maksimum koltuk sayısını giriniz:");
        // var maxSeatCapacity = scanner.nextInt();
        // return new AdminInput(destination, initialLocation, travelTime, price, coeff,
        // maxSeatCapacity);
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
                if (selectionForVehicle == 1) {
                    vehicleName = "Uçak";
                } else if (selectionForVehicle == 2) {
                    vehicleName = "Tren";
                } else if (selectionForVehicle == 3) {
                    vehicleName = "Otobüs";
                } else {
                    throw new Exception("bulunamadı");
                }

                scanner = new Scanner(new File("./TravelPlan.txt"));
                while (scanner.hasNextLine()) {
                    var line = scanner.nextLine().split(",");
                    if (vehicleName.equals(line[0]) && destination.equals(line[3]) && initialLocation.equals(line[4])) {
                        switch (vehicleName) {
                            case "Uçak":
                                appendToFile("./SeatSchema.txt", "Uçak" + Airplane.shemaOfSeats() + "\n");
                                break;
                            case "Tren":
                                appendToFile("./SeatSchema.txt", "Tren" + Train.shemaOfSeats() + "\n");
                                break;
                            case "Otobüs":
                                appendToFile("./SeatSchema.txt", "Otobüs" + Bus.shemaOfSeats() + "\n");
                                break;
                        }
                    }
                }
                scanner.close();

                break;
            case 2:
                // kullanıcı girişi
                var isAdminLogged = false;
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
                        appendToFile("./TravelPlan.txt", airplane.toString());
                        break;
                    case 2:
                        Transit train = new Train(getInput(Train.INPUTS));
                        appendToFile("./TravelPlan.txt", train.toString());
                        break;
                    case 3:
                        Transit bus = new Bus(getInput(Train.INPUTS));
                        appendToFile("./TravelPlan.txt", bus.toString());
                        break;
                    default:
                        throw new Exception("bulunamadı!");
                }
                break;
            default:
                throw new Exception("invalid selection");
        }
    }

    private static ArrayList<String> readFileToArray(String filePath) throws FileNotFoundException {
        var file = new File(filePath);
        var scanner = new Scanner(file);
        var fileContent = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            fileContent.add(scanner.nextLine());
        }
        scanner.close();
        return fileContent;
    }

    private static void appendToFile(String filePath, String value) throws Exception {
        var file = new File(filePath);
        var fileWriter = new FileWriter(file, true);
        fileWriter.write(value + "\n");
        fileWriter.close();
    }

}