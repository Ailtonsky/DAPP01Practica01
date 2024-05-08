/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Usuario
 */
public class VentaDao implements Dao<Venta> {

    @Override
    public void save(Venta venta) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.save(venta);

        t.commit();
        session.close();
    }

    @Override
    public void delete(Venta venta) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.delete(venta);

        t.commit();
        session.close();
    }

    @Override
    public void update(Venta venta) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.update(venta);

        t.commit();
        session.close();
    }

    @Override
    public List<Venta> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Venta> ventas = null;

        Query<Venta> query = session.createQuery("FROM venta", Venta.class);
        ventas = query.list();

        session.close();

        return ventas;
    }

    @Override
    public Venta get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Venta venta = session.get(Venta.class, id);

        session.close();

        return venta;
    }

}
