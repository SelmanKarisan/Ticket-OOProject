import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private static Scanner scanner;
    private static File file;
    private static FileWriter fileWriter;
    private static ArrayList<String> fileContent;
    private static String destination;
    private static String initialLocation;
    private static String travelTime;
    private static int selectionForTravelTime;
    private static double price;
    private static double coeff;
    private static int maxSeatCapacity;
    
    public static void inputForAdmin(){
        System.out.println("Varış yerini giriniz:");
         destination=scanner.next();
        System.out.println("Başlangıç yeri seçiniz:");
         initialLocation=scanner.next();
        System.out.println("Seyehat edilecek zamanı seçiniz:\n1:Sabah\n2:Öğle\n3:Akşam\n4:Gece");
         selectionForTravelTime=scanner.nextInt();
        switch (selectionForTravelTime) {
            case 1:
            travelTime="Sabah";
            break;
            case 2:
            travelTime="Öğle";
            break;
            case 3:
            travelTime="Akşam";
            break;
            case 4:
            travelTime="Gece"; 
                break;
            default:
                break;
        }
        System.out.println("Seyehat fiyatını giriniz:");
         price=scanner.nextDouble();
        System.out.println("Seyehat pahalılık katsayısını giriniz:");
         coeff=scanner.nextDouble();
        System.out.println("Maksimum koltuk sayısını giriniz:");
         maxSeatCapacity=scanner.nextInt();
                
    }
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
            String fileContent = "";
            while (scanner.hasNextLine()) {
                fileContent += scanner.nextLine();
            }
            System.out.println(fileContent);
            

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
                    inputForAdmin();
                    Airplane airplane = new Airplane(price, travelTime, destination, initialLocation, coeff, maxSeatCapacity);
                    file = new File("./TravelPlan.txt");
                    fileWriter = new FileWriter(file, true);
                    fileWriter.write(airplane.toString());
                    fileWriter.write("Airplane" + "\n-----------------" + airplane.shemaOfSeats());
                    break;
                case 2:
                    inputForAdmin();
                    // Train train = new Train(price, travelTime, destination, initialLocation,
                    // coefficentOfPrice,
                    // maxSeatCapacity);
                    break;
                case 3:
                    inputForAdmin();
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
