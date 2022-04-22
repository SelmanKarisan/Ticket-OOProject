import java.util.Scanner;

public class Test {

    private static Scanner scanner;

    public static void main(String[] args) {
         scanner = new Scanner(System.in);
        System.out.println("Marmara Turizm'e Hoşgeldiniz");
        System.out.println("Bilet almak için: 1 \n Seyehat oluşturmak için: 2 ");
        int Selection=scanner.nextInt();
        //Bilet alma sistemi için 
        if(Selection==1){
            System.out.println("Varış noktası giriniz:(İlk harfini büyük giriniz !!! )");
            String destinationInput = scanner.next();
            System.out.println( "Başlangıç noktası giriniz:(İlk harfi büyük giriniz !!!)");
            String initialLocationInput=scanner.next();
            System.out.println("Seyehat etmek istediğiniz aracı seçiniz:\n 1:Tren\n2:Uçak\n3:Otobüs");
            int SelectionforVehicleInput=scanner.nextInt();
        }
        //seyehat ekleme sistemi için 
        else if(Selection==2){
            

            // kullanıcı doğru giriş yaptığı zaman
            Boolean entry =true;
            while(entry){
            System.out.println("Kullanıcı adını giriniz:");
            String UserName=scanner.next();
            System.out.println("Şifrenizi giriniz:");
            String password=scanner.next();
                if(UserName.equals("admin_marmara")&&password.equals("1883")){

                entry=false;
                }else if(UserName.equals("admin_marmara") && !password.equals("1883")){
                System.out.println("Şifreniz yanlış lütfen tekrar deneyiniz");
                }else if(!UserName.equals("admin_marmara") && password.equals("1883")){
                System.out.println("Kullanıcı adınız yanlış lütfen tekrar deneyiniz");
                }else if(!UserName.equals("admin_marmara") && !password.equals("1883")){
                    System.out.println("Kullanıcı adınız ve şifreniz yanlış lütfen tekrar deneyiniz");
                }

            }
            //Kullanıcı giriş yaptıktan sonra 
            System.out.println("Hangi araç için sefer eklemek istiyorsunuz:\n1:Uçak\n2:Otobüs\n3:Tren");
            int SelectionforTripType =scanner.nextInt();
            

            

        }
    
        //    Bus bus = new Bus(31, 31, "destination", "initialLocation", 31.31, 31);  
        // bus.generateSeats(31);
            

        int selection = scanner.nextInt();

        if (selection == 2) {
            System.out.print("Hangi araç için sefer eklemek istiyorsunuz(1, 2 ya da 3'ü tuşlayın)");
            System.out.println("1-Uçak");
            System.out.println("2-Tren");
            System.out.println("3-Otobüs");
            int transitSelection = scanner.nextInt();
            switch (transitSelection) {
                case 1:
                 //   Airplane airplane = new Airplane(price, travelTime, destination, initialLocation, coefficentOfPrice,
                       //     maxSeatCapacity);
                    break;
                case 2:
                   // Train train = new Train(price, travelTime, destination, initialLocation, coefficentOfPrice,
                     //       maxSeatCapacity);
                    break;
                case 3:
                    //Bus bus = new Bus(price, travelTime, destination, initialLocation, coefficentOfPrice,
                      //2
                      //      maxSeatCapacity);
                    break;
            
                default:
                    break;
            }
        }
        
    }
}
