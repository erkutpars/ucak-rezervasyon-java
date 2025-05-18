package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Rezervasyon;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class VeriKaydedici {
    public static void kaydetJSON(List<Rezervasyon> rezervasyonlar, String dosyaYolu) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(dosyaYolu)) {
            gson.toJson(rezervasyonlar, writer);
            System.out.println("Rezervasyonlar kaydedildi: " + dosyaYolu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
