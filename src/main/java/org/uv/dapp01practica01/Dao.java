/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.dapp01practica01;

import java.util.List;

/**
 *
 * @author Usuario
 * @param <T>
 */
public interface Dao<T> {
    
    public void save(T t);
    
    public void delete(T t);
    
    public void update(T t);
    
    public List<T> get();
    
    public T get(long id);
}
