/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


/**
 *
 * @author domin
 */
public class SolicitudDatos {

    public void cargarSolicitudes(int usuarioId, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Descripción");
        modelo.addColumn("Estado");
        modelo.addColumn("Fecha");

        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();

        if (con != null) {
            try {
                String sql = "SELECT descripcion, estado, fecha FROM solicitudes WHERE usuario_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, usuarioId);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    String descripcion = rs.getString("descripcion");
                    String estado = rs.getString("estado");
                    String fecha = rs.getString("fecha");
                    modelo.addRow(new Object[]{descripcion, estado, fecha});
                }

                tabla.setModel(modelo); // <- Aquí usamos el JTable que ya está en el formulario

                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar solicitudes: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
        }
    }

}
