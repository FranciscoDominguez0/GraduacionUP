/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author domin
 */
public class NotificacionesDAO {
    
    public DefaultTableModel obtenerNotificaciones() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Mensaje");
        modelo.addColumn("Estado");
        modelo.addColumn("Fecha");

        String sql = "SELECT mensaje, estado, fecha FROM notificaciones";

        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getString("mensaje");
                fila[1] = rs.getString("estado");
                fila[2] = rs.getString("fecha");
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener notificaciones: " + e.getMessage());
        }

        return modelo;
    }
    
}
