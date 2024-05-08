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
public class ClienteDao implements Dao<Cliente> {

    @Override
    public void save(Cliente cliente) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.save(cliente);

        t.commit();
        session.close();
    }

    @Override
    public void delete(Cliente cliente) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.delete(cliente);

        t.commit();
        session.close();
    }

    @Override
    public void update(Cliente cliente) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.update(cliente);

        t.commit();
        session.close();
    }

    @Override
    public List get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> clientes = null;

        Query<Cliente> query = session.createQuery("FROM cliente", Cliente.class);
        clientes = query.list();

        session.close();

        return clientes;

    }

    @Override
    public Cliente get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = session.get(Cliente.class, id);

        session.close();

        return cliente;
    }

}
