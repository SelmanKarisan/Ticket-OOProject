import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("Kullanıcı adını giriniz:");
            String UserName=scanner.next();
            System.out.println("Şifrenizi giriniz:");
            String password=scanner.next();












        }
    
        //    Bus bus = new Bus(31, 31, "destination", "initialLocation", 31.31, 31);  
        // bus.generateSeats(31);
            
    }
}
