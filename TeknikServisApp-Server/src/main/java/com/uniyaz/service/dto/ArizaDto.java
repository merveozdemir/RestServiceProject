package com.uniyaz.service.dto;

import com.uniyaz.domain.enums.EnumArizaDurum;

import java.util.Date;

public class ArizaDto {
    private Long id;
    private String musteriAdi;
    private String musteriSoyadi;
    private String musteriTcNo;
    private String arizaIcerik;
    private Date arizaKayitTarihi;
    private EnumArizaDurum enumArizaDurum;
    private String arizaAciklama;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    public void setMusteriSoyadi(String musteriSoyadi) {
        this.musteriSoyadi = musteriSoyadi;
    }

    public String getMusteriTcNo() {
        return musteriTcNo;
    }

    public void setMusteriTcNo(String musteriTcNo) {
        this.musteriTcNo = musteriTcNo;
    }

    public String getArizaIcerik() {
        return arizaIcerik;
    }

    public void setArizaIcerik(String arizaIcerik) {
        this.arizaIcerik = arizaIcerik;
    }

    public Date getArizaKayitTarihi() {
        return arizaKayitTarihi;
    }

    public void setArizaKayitTarihi(Date arizaKayitTarihi) {
        this.arizaKayitTarihi = arizaKayitTarihi;
    }

    public EnumArizaDurum getEnumArizaDurum() {
        return enumArizaDurum;
    }

    public void setEnumArizaDurum(EnumArizaDurum enumArizaDurum) {
        this.enumArizaDurum = enumArizaDurum;
    }

    public String getArizaAciklama() {
        return arizaAciklama;
    }

    public void setArizaAciklama(String arizaAciklama) {
        this.arizaAciklama = arizaAciklama;
    }
}
