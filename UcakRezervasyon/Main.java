import models.*;
import service.VeriKaydedici;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    static List<Ucus> ucuslar = new ArrayList<>();
    static List<Rezervasyon> rezervasyonlar = new ArrayList<>();

    public static void main(String[] args) {
        veriOlustur();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mevcut Uçuşlar:");
        for (int i = 0; i < ucuslar.size(); i++) {
            System.out.println((i + 1) + ". " + ucuslar.get(i));
        }

        System.out.print("Uçuş seçin (numara): ");
        int secim = scanner.nextInt();
        scanner.nextLine(); // yeni satır temizliği

        if (secim < 1 || secim > ucuslar.size()) {
            System.out.println("Geçersiz seçim.");
            return;
        }

        Ucus secilenUcus = ucuslar.get(secim - 1);
        int rezervasyonSayisi = (int) rezervasyonlar.stream()
            .filter(r -> r.getUcus().equals(secilenUcus))
            .count();

        if (rezervasyonSayisi >= secilenUcus.getUcak().getKoltukKapasitesi()) {
            System.out.println("Bu uçuşta boş koltuk yok.");
            return;
        }

        System.out.print("Ad: ");
        String ad = scanner.nextLine();
        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();
        System.out.print("Yaş: ");
        int yas = scanner.nextInt();

        Rezervasyon rezervasyon = new Rezervasyon(secilenUcus, ad, soyad, yas);
        rezervasyonlar.add(rezervasyon);
        VeriKaydedici.kaydetJSON(rezervasyonlar, "data/rezervasyonlar.json");

        System.out.println("Rezervasyon başarıyla yapıldı.");
    }

    private static void veriOlustur() {
        Ucak u1 = new Ucak("Boeing 737", "Boeing", "SN1234", 5);
        Lokasyon l1 = new Lokasyon("Türkiye", "İstanbul", "IST", true);
        Ucus ucs1 = new Ucus(l1, u1, LocalDateTime.now().plusDays(1));

        ucuslar.add(ucs1);
    }
}
