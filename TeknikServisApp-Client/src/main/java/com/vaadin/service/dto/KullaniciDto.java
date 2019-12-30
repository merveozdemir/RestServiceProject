package com.vaadin.service.dto;

public class KullaniciDto {
    private Long id;
    private String adi;
    private String soyadi;
    private String kullaniciAdi;
    private String sifre;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getKullaniciAdi() { return kullaniciAdi; }

    public void setKullaniciAdi(String kullaniciAdi) { this.kullaniciAdi = kullaniciAdi; }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public String toString() {
        return adi + " " + soyadi;
    }
}
