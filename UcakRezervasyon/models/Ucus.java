package models;

import java.time.LocalDateTime;

public class Ucus {
    private Lokasyon lokasyon;
    private Ucak ucak;
    private LocalDateTime saat;

    public Ucus(Lokasyon lokasyon, Ucak ucak, LocalDateTime saat) {
        this.lokasyon = lokasyon;
        this.ucak = ucak;
        this.saat = saat;
    }

    public Lokasyon getLokasyon() { return lokasyon; }
    public Ucak getUcak() { return ucak; }
    public LocalDateTime getSaat() { return saat; }

    @Override
    public String toString() {
        return lokasyon + " - Saat: " + saat.toString() + " - Uçak: " + ucak.getModel();
    }
}
