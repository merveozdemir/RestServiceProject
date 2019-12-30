package com.uniyaz.domain;

import com.sun.istack.NotNull;
import com.uniyaz.common.BaseDomain;
import com.uniyaz.domain.enums.EnumArizaDurum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ARIZA")
public class Ariza extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 50)
    private String musteriAdi;

    @NotNull
    @Column(length = 50)
    private String musteriSoyadi;

    @Column(unique = true)
    private String musteriTcNo;

    @Column(length = 255)
    private String arizaIcerik;

    @Temporal(TemporalType.DATE)
    private Date arizaKayitTarihi;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EnumArizaDurum enumArizaDurum;

    @Column(length = 255)
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
