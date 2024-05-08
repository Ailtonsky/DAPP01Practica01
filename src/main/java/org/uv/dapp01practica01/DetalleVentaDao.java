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
public class DetalleVentaDao implements Dao<DetalleVenta> {

    @Override
    public void save(DetalleVenta detalleVenta) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.save(detalleVenta);

        t.commit();
        session.close();
    }

    @Override
    public void delete(DetalleVenta detalleVenta) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.delete(detalleVenta);

        t.commit();
        session.close();
    }

    @Override
    public void update(DetalleVenta detalleVenta) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.update(detalleVenta);

        t.commit();
        session.close();
    }

    @Override
    public List<DetalleVenta> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<DetalleVenta> detalleVentas = null;

        Query<DetalleVenta> query = session.createQuery("FROM detalle_venta", DetalleVenta.class);
        detalleVentas = query.list();

        session.close();

        return detalleVentas;
    }

    @Override
    public DetalleVenta get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        DetalleVenta detalleVenta = session.get(DetalleVenta.class, id);

        session.close();

        return detalleVenta;
    }
    
}
