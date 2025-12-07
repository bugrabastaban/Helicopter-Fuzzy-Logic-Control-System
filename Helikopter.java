package bulanik1;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Helikopter {
    private FIS fis;
    private double gKuvveti;
    private double agirlik;
    private double rotorHizi;

    public Helikopter(double gKuvveti, double agirlik, double rotorHizi) throws URISyntaxException {
        this.gKuvveti = gKuvveti;
        this.agirlik = agirlik;
        this.rotorHizi = rotorHizi;

        // FCL dosyasını yükle
        fis = FIS.load("src/bulanik1/helikopter.fcl", true);
        if (fis == null) {
            System.err.println("FCL dosyasi yuklenemedi!");
            System.exit(1);
        }


        // Girdi değişkenlerini ata
        fis.setVariable("GKuvvet", gKuvveti);
        fis.setVariable("Agirlik", agirlik);
        fis.setVariable("RotorHizi", rotorHizi);

        // Modeli çalıştır
        fis.evaluate();
    }

    public FIS getModel() {
        return fis;
    }

    @Override
    public String toString() {
        double sonucDegeri = fis.getVariable("HavadaKalma").getValue();
        return "G Kuvveti: " + gKuvveti + "\n" +
               "Ağırlık: " + agirlik + "\n" +
               "Rotor Hızı: " + rotorHizi + "\n" +
               "Havada Kalma Değeri: " + sonucDegeri;
    }
}