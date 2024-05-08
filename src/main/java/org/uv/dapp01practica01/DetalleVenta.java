/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Usuario
 */

@Entity(name = "detalle_venta")
public class DetalleVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private long id_detalle_venta;
    
    @Column
    private long id_venta;
    
    @Column
    private long id_producto;
    
    @Column
    private int cantidad;
    
    @Column
    private String descripcion;
    
    @Column
    private BigDecimal precio;

    public long getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(long id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public long getId_venta() {
        return id_venta;
    }

    public void setId_venta(long id_venta) {
        this.id_venta = id_venta;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    
    
}
