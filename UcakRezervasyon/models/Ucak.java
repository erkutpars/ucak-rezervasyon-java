package models;

public class Ucak {
    private String model;
    private String marka;
    private String seriNo;
    private int koltukKapasitesi;

    public Ucak(String model, String marka, String seriNo, int koltukKapasitesi) {
        this.model = model;
        this.marka = marka;
        this.seriNo = seriNo;
        this.koltukKapasitesi = koltukKapasitesi;
    }

    public String getModel() { return model; }
    public String getMarka() { return marka; }
    public String getSeriNo() { return seriNo; }
    public int getKoltukKapasitesi() { return koltukKapasitesi; }

    @Override
    public String toString() {
        return model + " - " + marka + " - Seri No: " + seriNo + " - Koltuk: " + koltukKapasitesi;
    }
}
