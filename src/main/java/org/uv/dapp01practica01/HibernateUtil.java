/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Usuario
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/ejemplo1");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "");
            
            // THIS ONLY ON DEVELOPMENT
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            //settings.put(Environment.HBM2DDL_AUTO, "create-drop");

            configuration.setProperties(settings);
            
            // ADD POJOES AS ENTITIES
            configuration.addAnnotatedClass(Cliente.class);
            configuration.addAnnotatedClass(Producto.class);
            configuration.addAnnotatedClass(Venta.class);
            configuration.addAnnotatedClass(DetalleVenta.class);
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
        }
        
        return sessionFactory;
    }
    
}
