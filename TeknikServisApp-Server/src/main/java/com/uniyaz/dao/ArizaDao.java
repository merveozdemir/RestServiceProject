package com.uniyaz.dao;

import com.uniyaz.domain.Ariza;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ArizaDao {

    public Ariza kaydetAriza(Ariza ariza){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            ariza = (Ariza) session.merge(ariza);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ariza;
    }

    public List<Ariza> tumArizalariGetir(){
        List<Ariza> arizaList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select ariza From Ariza ariza";
            Query query = session.createQuery(hql);
            arizaList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return arizaList;
    }

    public List<Ariza> getArizaByName(String musteriAdi){
        List<Ariza> arizaList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select ariza From Ariza ariza where ariza.musteriAdi like :ad";
            Query query = session.createQuery(hql);
            query.setParameter("ad", '%'+musteriAdi+'%');
            arizaList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return arizaList;
    }

    public List<Ariza> getArizaByTcNo(String musteriTcNo){
        List<Ariza> arizaList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select ariza From Ariza ariza where ariza.musteriTcNo like :tcNo";
            Query query = session.createQuery(hql);
            query.setParameter("tcNo", '%'+musteriTcNo+'%');
            arizaList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return arizaList;
    }

}
