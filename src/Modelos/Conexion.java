/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author domin
 */
public class Conexion {
    
      
    public static final String URL = "jdbc:mysql://be7hl0vroswrv8hunkxi-mysql.services.clever-cloud.com:3306/be7hl0vroswrv8hunkxi";
    public static final String USER = "upujfg1iw1jwy9wb";     
    public static final String CLAVE = "riJSMap5teZZfHXDUQma";  
     
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                null,
                "Error al conectar a la base de datos: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        return con;
    }
    
}
