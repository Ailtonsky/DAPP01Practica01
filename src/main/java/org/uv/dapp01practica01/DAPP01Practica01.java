/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ailton
 */
public class DAPP01Practica01 {

    public static void main(String[] args) {
        Connection con=null;
        try {
            String url = "jdbc:postgresql://localhost:5432/ejemplo1";
            String usr = "ailton";
            String pwd = "eaedcv55";
            con=DriverManager.getConnection(url,usr,pwd);
            
            Statement st=con.createStatement();
            String sql="insert into empleadotemporal (nombre, direccion,telefono)"+
                    "values ('Antonio', 'La presa', '12345')";
            st.execute(sql);
            
            
            Logger.getLogger(DAPP01Practica01.class.getName()).
                    log(Level.INFO, "Se conecto");
        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
        
            
    }
}
