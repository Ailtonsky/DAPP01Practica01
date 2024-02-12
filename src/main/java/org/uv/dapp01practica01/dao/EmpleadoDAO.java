/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.uv.dapp01practica01.model.Empleado;

/**
 *
 * @author Usuario
 */
public class EmpleadoDAO {

    private final Connection con;

    public EmpleadoDAO(Connection con) {
        this.con = con;
    }

    public void createEmpleado(String nombre, String direccion, String telefono) throws SQLException {
        String sql = "INSERT INTO empleadotemporal (nombre, direccion, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, telefono);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Empleado creado correctamente.");
            } else {
                System.out.println("No se pudo crear el empleado.");
            }
        }
    }

    public void readEmpleados() throws SQLException {
        String sql = "SELECT * FROM empleadotemporal";
        try (PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Empleado empleado = new Empleado(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("telefono"));
                System.out.println(empleado);
            }
        }
    }

    public void updateEmpleado(int id, String nombre, String direccion, String telefono) throws SQLException {
        String sql = "UPDATE empleadotemporal SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, telefono);
            pst.setInt(4, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Empleado actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el empleado.");
            }
        }
    }

    public void deleteEmpleado(int id) throws SQLException {
        String sql = "DELETE FROM empleadotemporal WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el empleado.");
            }
        }
    }
}
