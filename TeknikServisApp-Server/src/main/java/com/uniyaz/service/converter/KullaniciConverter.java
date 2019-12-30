package com.uniyaz.service.converter;

import com.uniyaz.domain.Ariza;
import com.uniyaz.domain.Kullanici;
import com.uniyaz.service.dto.ArizaDto;
import com.uniyaz.service.dto.KullaniciDto;

import javax.management.Notification;

public class KullaniciConverter {

    public Kullanici convertToKullanici(KullaniciDto kullaniciDto) {
        Kullanici kullanici = new Kullanici();
        try {
            kullanici.setId(kullaniciDto.getId());
            kullanici.setAdi(kullaniciDto.getAdi());
            kullanici.setSoyadi(kullaniciDto.getSoyadi());
            kullanici.setKullaniciAdi(kullaniciDto.getKullaniciAdi());
            kullanici.setSifre(kullaniciDto.getSifre());
            return kullanici;
        } catch (NullPointerException e) {
            return null;
        }

    }

    public KullaniciDto convertToKullaniciDto(Kullanici kullanici) {
        KullaniciDto kullaniciDto = new KullaniciDto();
        try {
            kullaniciDto.setId(kullanici.getId());
            kullaniciDto.setAdi(kullanici.getAdi());
            kullaniciDto.setSoyadi(kullanici.getSoyadi());
            kullaniciDto.setKullaniciAdi(kullanici.getKullaniciAdi());
            kullaniciDto.setSifre(kullanici.getSifre());

            return kullaniciDto;
        } catch (NullPointerException e) {
            return null;
        }
    }
}
