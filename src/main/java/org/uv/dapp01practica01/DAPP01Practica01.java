/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uv.dapp01practica01.dao.EmpleadoDAO;

/**
 *
 * @author ailton
 */
public class DAPP01Practica01 {

    private static final String URL = "jdbc:postgresql://localhost:5432/ejemplo1";
    private static final String USR = "postgres";
    private static final String PWD = "admin123";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USR, PWD)) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(con);
            Scanner scanner = new Scanner(System.in);
            int option;
            do {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Crear empleado");
                System.out.println("2. Leer empleados");
                System.out.println("3. Actualizar empleado");
                System.out.println("4. Eliminar empleado");
                System.out.println("5. Salir");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        createEmpleado(empleadoDAO, scanner);
                        break;
                    case 2:
                        empleadoDAO.readEmpleados();
                        break;
                    case 3:
                        updateEmpleado(empleadoDAO, scanner);
                        break;
                    case 4:
                        deleteEmpleado(empleadoDAO, scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (option != 5);
        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void createEmpleado(EmpleadoDAO empleadoDAO, Scanner scanner) throws SQLException {
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese dirección:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese teléfono:");
        String telefono = scanner.nextLine();
        empleadoDAO.createEmpleado(nombre, direccion, telefono);
    }

    private static void updateEmpleado(EmpleadoDAO empleadoDAO, Scanner scanner) throws SQLException {
        System.out.println("Ingrese el ID del empleado a actualizar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese nuevo nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese nueva dirección:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese nuevo teléfono:");
        String telefono = scanner.nextLine();
        empleadoDAO.updateEmpleado(id, nombre, direccion, telefono);
    }

    private static void deleteEmpleado(EmpleadoDAO empleadoDAO, Scanner scanner) throws SQLException {
        System.out.println("Ingrese el ID del empleado a eliminar:");
        int id = scanner.nextInt();
        empleadoDAO.deleteEmpleado(id);
    }
}
