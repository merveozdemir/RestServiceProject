package com.uniyaz;

import com.uniyaz.dao.ArizaDao;
import com.uniyaz.dao.KullaniciDao;
import com.uniyaz.domain.Ariza;
import com.uniyaz.domain.Kullanici;
import com.uniyaz.domain.enums.EnumArizaDurum;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class AppTest {
    public static void main(String[] args) {
         SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        //   kullaniciKontrol();

        //  arizaOlustur();
//        System.out.println("get ariza by name");
//        getArizaByName();
//
//        System.out.println("get ariza by id");
//        getArizaById();

    }

//
//    private static void arizaOlustur() {
//        Ariza ariza = new Ariza();
//        ariza.setId(2L);
//        ariza.setMusteriAdi("me");
//        ariza.setMusteriSoyadi("a");
//        ariza.setMusteriTcNo("1");
//        ariza.setArizaIcerik("batarja ");
//        ariza.setEnumArizaDurum(EnumArizaDurum.Giderilmedi);
//
//        ArizaDao arizaDao = new ArizaDao();
//        ariza = arizaDao.kaydetAriza(ariza);
//        System.out.println("Arıza kaydedildi");
//    }
//
//    private static void kullaniciKontrol() {
//        Kullanici kullanici = new Kullanici();
//        kullanici.setAdi("Merve");
//        kullanici.setId(1L);
//        kullanici.setSoyadi("Özdemir");
//        kullanici.setSifre("123");
//
//        KullaniciDao kullaniciDao = new KullaniciDao();
//        Kullanici gelenKullanici = kullaniciDao.kullaniciyiGetir(kullanici.getKullaniciAdi(), kullanici.getSifre());
//        System.out.println(gelenKullanici.equals(kullanici));
//    }
}
