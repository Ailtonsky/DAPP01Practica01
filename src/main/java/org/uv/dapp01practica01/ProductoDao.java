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
public class ProductoDao implements Dao<Producto> {

    @Override
    public void save(Producto producto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.save(producto);

        t.commit();
        session.close();
    }

    @Override
    public void delete(Producto producto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.delete(producto);

        t.commit();
        session.close();
    }

    @Override
    public void update(Producto producto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.delete(producto);

        t.commit();
        session.close();
    }

    @Override
    public List<Producto> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Producto> productos = null;

        Query<Producto> query = session.createQuery("FROM producto", Producto.class);
        productos = query.list();

        session.close();

        return productos;
    }

    @Override
    public Producto get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Producto producto = session.get(Producto.class, id);

        session.close();

        return producto;
    }
    
}
