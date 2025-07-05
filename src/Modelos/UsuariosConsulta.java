/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author domin
 */
public class UsuariosConsulta {
    
      Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Usuarios login(String usuario, String clave){
    String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?";
    Usuarios us = new Usuarios();
    try {
        con = cn.getConexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, clave);
        rs = ps.executeQuery();
        if (rs.next()) {
            us.setNombreUsuario(rs.getString("nombre_usuario"));
            us.setClave(rs.getString("contraseña"));
          
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }
    return us;
}
    
    
    
    
    
}
