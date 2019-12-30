package com.uniyaz.domain;

import com.sun.istack.NotNull;
import com.uniyaz.common.BaseDomain;

import javax.persistence.*;

@Entity
@Table(name = "KULLANICI")
public class Kullanici extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, unique = true)
    private String kullaniciAdi;

    @Column(length = 50)
    private String adi;

    @Column(length = 50)
    private String soyadi;

    @NotNull
    @Column(length = 50)
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

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
