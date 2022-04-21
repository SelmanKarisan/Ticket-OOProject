
public abstract class PublicTransformation {
	
	private int Fiyat;
	private int Seyehat_Suresi;
	private String Gidilecek_Yer;
	private String Baslangic_Konumu;
	private String sirket_adi;
	
	


	public PublicTransformation(int fiyat, int seyehat_Suresi, String gidilecek_Yer, String baslangic_Konumu,String sirket_adi) {
		super();
		Fiyat = fiyat;
		Seyehat_Suresi = seyehat_Suresi;
		Gidilecek_Yer = gidilecek_Yer;
		this.sirket_adi=sirket_adi;
		Baslangic_Konumu = baslangic_Konumu;
		
	}
	
	
	public String getSirket_adi() {
		return sirket_adi;
	}

	public void setSirket_adi(String sirket_adi) {
		this.sirket_adi = sirket_adi;
	}
	
	public int getFiyat() {
		return Fiyat;
	}




	public void setFiyat(int fiyat) {
		Fiyat = fiyat;
	}




	public int getSeyehat_Suresi() {
		return Seyehat_Suresi;
	}




	public void setSeyehat_Suresi(int seyehat_Suresi) {
		Seyehat_Suresi = seyehat_Suresi;
	}




	public String getGidilecek_Yer() {
		return Gidilecek_Yer;
	}




	public void setGidilecek_Yer(String gidilecek_Yer) {
		Gidilecek_Yer = gidilecek_Yer;
	}




	public String getBaslangic_Konumu() {
		return Baslangic_Konumu;
	}




	public void setBaslangic_Konumu(String baslangic_Konumu) {
		Baslangic_Konumu = baslangic_Konumu;
	}




	
	
	
	
	
	
	

}
