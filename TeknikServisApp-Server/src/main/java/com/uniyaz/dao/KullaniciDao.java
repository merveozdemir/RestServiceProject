package com.uniyaz.dao;

import com.uniyaz.domain.Kullanici;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class KullaniciDao {

    public Kullanici kullaniciyiGetir(String kullaniciAdi, String sifre){
        Kullanici kullanici = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select kullanici From Kullanici kullanici where  kullanici.kullaniciAdi =:adi and kullanici.sifre=:sifre";
            Query query = session.createQuery(hql);
            query.setParameter("adi", kullaniciAdi);
            query.setParameter("sifre", sifre);
            kullanici = (Kullanici) query.uniqueResult();
            System.out.println(kullanici.getId() + " "+ kullanici.getAdi() );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullanici;
    }
}
