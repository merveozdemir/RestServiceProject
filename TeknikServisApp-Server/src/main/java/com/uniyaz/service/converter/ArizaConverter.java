package com.uniyaz.service.converter;

import com.uniyaz.domain.Ariza;
import com.uniyaz.service.dto.ArizaDto;

import java.util.ArrayList;
import java.util.List;

public class ArizaConverter {

    public Ariza convertToAriza(ArizaDto arizaDto) {
        Ariza ariza = new Ariza();

        ariza.setId(arizaDto.getId());
        ariza.setMusteriTcNo(arizaDto.getMusteriTcNo());
        ariza.setMusteriAdi(arizaDto.getMusteriAdi());
        ariza.setMusteriSoyadi(arizaDto.getMusteriSoyadi());
        ariza.setArizaKayitTarihi(arizaDto.getArizaKayitTarihi());
        ariza.setArizaIcerik(arizaDto.getArizaIcerik());
        ariza.setEnumArizaDurum(arizaDto.getEnumArizaDurum());
        ariza.setArizaAciklama(arizaDto.getArizaAciklama());
        return ariza;

    }

    public ArizaDto convertToArizaDto(Ariza ariza) {
        ArizaDto arizaDto = new ArizaDto();

        arizaDto.setId(ariza.getId());
        arizaDto.setMusteriTcNo(ariza.getMusteriTcNo());
        arizaDto.setMusteriAdi(ariza.getMusteriAdi());
        arizaDto.setMusteriSoyadi(ariza.getMusteriSoyadi());
        arizaDto.setArizaKayitTarihi(ariza.getArizaKayitTarihi());
        arizaDto.setArizaIcerik(ariza.getArizaIcerik());
        arizaDto.setEnumArizaDurum(ariza.getEnumArizaDurum());
        arizaDto.setArizaAciklama(ariza.getArizaAciklama());

        return arizaDto;
    }

    public List<ArizaDto> convertToArizaDtoList(List<Ariza> arizaList) {

        List<ArizaDto> arizaDtoList = new ArrayList<>();
        for (Ariza ariza : arizaList) {
            ArizaDto arizaDto = convertToArizaDto(ariza);
            arizaDtoList.add(arizaDto);
        }
        return arizaDtoList;
    }

}
