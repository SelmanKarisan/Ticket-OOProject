
public class Plane extends PublicTransformation implements IBilgilendirme{
	
	
	private String marka;
	private int kanat_sayisi;
	private int yedek_motor_sayisi;

	public Plane(int fiyat, int seyehat_Suresi, String gidilecek_Yer, String baslangic_Konumu) {
		super(fiyat, seyehat_Suresi, gidilecek_Yer, baslangic_Konumu, baslangic_Konumu);
		// TODO Auto-generated constructor stub
	}
	
	
	public Plane(int fiyat, int seyehat_Suresi, String gidilecek_Yer, String baslangic_Konumu, String sirket_adi,
			String marka, int kanat_sayisi, int yedek_motor_sayisi) {
		super(fiyat, seyehat_Suresi, gidilecek_Yer, baslangic_Konumu, sirket_adi);
		this.marka = marka;
		this.kanat_sayisi = kanat_sayisi;
		this.yedek_motor_sayisi = yedek_motor_sayisi;
	}


	public String getMarka() {
		return marka;
	}


	public void setMarka(String marka) {
		this.marka = marka;
	}


	public int getKanat_sayisi() {
		return kanat_sayisi;
	}


	public void setKanat_sayisi(int kanat_sayisi) {
		this.kanat_sayisi = kanat_sayisi;
	}


	public int getYedek_motor_sayisi() {
		return yedek_motor_sayisi;
	}


	public void setYedek_motor_sayisi(int yedek_motor_sayisi) {
		this.yedek_motor_sayisi = yedek_motor_sayisi;
	}


	@Override
	public void boskoltukgosterme() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dolukoltukgosterme() {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
	
}
