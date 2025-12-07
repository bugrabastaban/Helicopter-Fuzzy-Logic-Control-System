# Fuzzy Logic Based Helicopter Control System

## 🚀 Proje Hakkında
Bu proje, insansız hava araçlarının (İHA) uçuş stabilitesini sağlamak amacıyla geliştirilmiş bir **Bulanık Mantık (Fuzzy Logic)** kontrol simülasyonudur. Helikopterin *pitch* ve *roll* açılarındaki sapmaları analiz ederek motor güçlerini dinamik olarak ayarlar ve stabilizasyon sağlar.

## 🛠 Kullanılan Teknolojiler
* **Dil:** Java
* **Kütüphane:** JFuzzyLogic (FCL - Fuzzy Control Language)
* **Konseptler:** Otonom Kontrol Sistemleri, Kural Tabanlı Yapay Zeka

## ⚙️ Nasıl Çalışır?
Sistem, sensörlerden gelen (simüle edilen) açı bilgilerini alır ve aşağıdaki bulanık mantık aşamalarından geçirir:
1.  **Fuzzification (Bulanıklaştırma):** Kesin sayısal veriler (örn: 15 derece sapma) "Az Eğimli", "Çok Eğimli" gibi dilsel değişkenlere dönüştürülür.
2.  **Inference Engine (Çıkarım Motoru):** Tanımlanan kural tabanı (Rule Base) devreye girer.
    * *Örnek Kural:* `IF angle IS negative_big THEN rotor_power IS high`
3.  **Defuzzification (Durulaştırma):** Motorlara gönderilecek kesin güç değeri hesaplanır.
