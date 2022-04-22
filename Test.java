import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private static Scanner scanner;
    private static File file;
    private static FileWriter fileWriter;
    private static ArrayList<String> fileContent;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("Marmara Turizm'e Hoşgeldiniz");
        System.out.println("Bilet almak için: 1 \n Seyehat oluşturmak için: 2 ");
        int selection = scanner.nextInt();
        // Bilet alma sistemi için
        if (selection == 1) {
            System.out.println("Varış noktası giriniz:(İlk harfini büyük giriniz !!! )");
            String destination = scanner.next().toLowerCase();
            System.out.println("Başlangıç noktası giriniz:(İlk harfi büyük giriniz !!!)");
            String initialLocation = scanner.next().toLowerCase();
            System.out.println("Seyehat etmek istediğiniz aracı seçiniz:\n 1:Tren\n2:Uçak\n3:Otobüs");
            int selectionForVehicle = scanner.nextInt();
            file = new File("./SeatShema.txt");
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

            }
        }
        // seyehat ekleme sistemi için
        else if (selection == 2) {
            // kullanıcı doğru giriş yaptığı zaman
            boolean entry = true;
            while (entry) {
                System.out.println("Kullanıcı adını giriniz:");
                String userName = scanner.next();
                System.out.println("Şifrenizi giriniz:");
                String password = scanner.next();
                if (userName.equals("admin") && password.equals("1883")) {
                    entry = false;
                } else if (userName.equals("admin") && !password.equals("1883")) {
                    System.out.println("Şifreniz yanlış lütfen tekrar deneyiniz");
                } else if (!userName.equals("admin") && password.equals("1883")) {
                    System.out.println("Kullanıcı adınız yanlış lütfen tekrar deneyiniz");
                } else if (!userName.equals("admin") && !password.equals("1883")) {
                    System.out.println("Kullanıcı adınız ve şifreniz yanlış lütfen tekrar deneyiniz");
                }
            }
            // Kullancı girişi sonrası
            System.out.print("Hangi araç için sefer eklemek istiyorsunuz(1, 2 ya da 3'ü tuşlayın)");
            System.out.println("1-Uçak");
            System.out.println("2-Tren");
            System.out.println("3-Otobüs");
            int transitSelection = scanner.nextInt();

            switch (transitSelection) {
                case 1:
                    Airplane airplane = new Airplane(31, "Öğle", "destination", "initialLocation", 31.31, 20);
                    file = new File("./TravelPlan.txt");
                    fileWriter = new FileWriter(file, true);
                    fileWriter.write(airplane.toString());
                    fileWriter.write("Airplane" + "\n-----------------" + airplane.shemaOfSeats());
                    break;
                case 2:
                    // Train train = new Train(price, travelTime, destination, initialLocation,
                    // coefficentOfPrice,
                    // maxSeatCapacity);
                    break;
                case 3:
                    // Bus bus = new Bus(price, travelTime, destination, initialLocation,
                    // coefficentOfPrice,
                    // 2
                    // maxSeatCapacity);
                    break;
                default:
                    break;
            }
        }
    }
}
