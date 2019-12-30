package com.uniyaz.service.rest;

import com.uniyaz.dao.KullaniciDao;
import com.uniyaz.domain.Kullanici;
import com.uniyaz.service.converter.KullaniciConverter;
import com.uniyaz.service.dto.KullaniciDto;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kullanici")
public class KullaniciRestService {

    @POST
    @Path("/kullaniciyiGetir")
    @Produces(MediaType.APPLICATION_JSON)
    public Response kullaniciyiGetir(@FormParam("kullaniciAdi") String kullaniciAdi, @FormParam("sifre") String sifre) {
        KullaniciDao kullaniciDao = new KullaniciDao();
        Kullanici kullanici = kullaniciDao.kullaniciyiGetir(kullaniciAdi, sifre);

        KullaniciConverter kullaniciConverter = new KullaniciConverter();
        KullaniciDto kullaniciDto = kullaniciConverter.convertToKullaniciDto(kullanici);

        return Response.ok().entity(kullaniciDto).build();
    }
}
