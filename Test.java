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
                System.out.print("Seyehat etmek istediğiniz aracı seçiniz:\n1-Tren\n2-Uçak\n3-Otobüs");
                int selectionForVehicle = scanner.nextInt();

                var fileContent = readFileToArray("./SeatShema.txt");
                System.out.println(String.join("\n\r", fileContent));

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
                        Info airplane = new Airplane(getInput(Airplane.INPUTS));
                        appendToFile("./TravelPlan.txt", airplane.toString());
                        appendToFile("./SeatSchema.txt", "Airplane" + airplane.shemaOfSeats() + "\n");
                        break;
                    case 2:
                        // Train train = new Train(getInput(Train.INPUTS));

                        // Train train = new Train(price, travelTime, destination, initialLocation,
                        // coefficentOfPrice,
                        // maxSeatCapacity);
                        break;
                    case 3:
                        // inputForAdmin();
                        // Bus bus = new Bus(price, travelTime, destination, initialLocation,
                        // coefficentOfPrice,
                        // 2
                        // maxSeatCapacity);
                        break;
                    default:
                        break;
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
