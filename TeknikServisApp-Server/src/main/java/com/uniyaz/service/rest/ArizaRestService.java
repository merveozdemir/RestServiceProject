package com.uniyaz.service.rest;

import com.uniyaz.dao.ArizaDao;
import com.uniyaz.domain.Ariza;
import com.uniyaz.service.converter.ArizaConverter;
import com.uniyaz.service.dto.ArizaDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ariza")
public class ArizaRestService {

    @POST
    @Path("/arizaKaydet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response arizaKaydet(ArizaDto arizaDto){
        ArizaConverter arizaConverter = new ArizaConverter();
        Ariza ariza = arizaConverter.convertToAriza(arizaDto);

        ArizaDao arizaDao = new ArizaDao();
        ariza = arizaDao.kaydetAriza(ariza);

        ArizaDto savedArizaDto = arizaConverter.convertToArizaDto(ariza);

        return Response.ok().entity(savedArizaDto).build();
    }

    @POST
    @Path("/tumArizaListele")
    @Produces(MediaType.APPLICATION_JSON)
    public Response tumArizaListele(){
        ArizaDao arizaDao = new ArizaDao();
        List<Ariza> arizaList = arizaDao.tumArizalariGetir();

        ArizaConverter arizaConverter = new ArizaConverter();
        List<ArizaDto> arizaDtoList = arizaConverter.convertToArizaDtoList(arizaList);

        return Response.ok().entity(arizaDtoList).build();
    }


    @POST
    @Path("/adaGoreListele")
    @Produces(MediaType.APPLICATION_JSON)
    public Response adaGoreListele(String isim){
        ArizaDao arizaDao = new ArizaDao();
        List<Ariza> arizaListByName = arizaDao.getArizaByName(isim);

        ArizaConverter arizaConverter = new ArizaConverter();
        List<ArizaDto> arizaDtoList = arizaConverter.convertToArizaDtoList(arizaListByName);

        return Response.ok().entity(arizaDtoList).build();
    }

    @POST
    @Path("/tcNoyaGoreListele")
    @Produces(MediaType.APPLICATION_JSON)
    public Response tcNoyaGoreListele(String musteriTcNo){
        ArizaDao arizaDao = new ArizaDao();
        List<Ariza> arizaList = arizaDao.getArizaByTcNo(musteriTcNo);

        ArizaConverter arizaConverter = new ArizaConverter();
        List<ArizaDto> arizaDtoList = arizaConverter.convertToArizaDtoList(arizaList);

        return Response.ok().entity(arizaDtoList).build();
    }



}
