/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contoladores;

import Modelos.Usuarios;
import Modelos.UsuariosConsulta;
import Vistas.AdminForm;
import Vistas.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author domin
 */
public class ControladorUsuario implements ActionListener {

    final private LoginForm login;
    private Usuarios usuario;
    final private UsuariosConsulta consulta;

    public ControladorUsuario(LoginForm login, Usuarios usuario, UsuariosConsulta consulta) {
        this.login = login;
        this.usuario = usuario;
        this.consulta = consulta;

        login.btnLogin1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.btnLogin1) {
            if (login.txtusuario.getText().equals("")
                    || String.valueOf(login.txtClave.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");

            } else {
                String user = login.txtusuario.getText();
                String clave = String.valueOf(login.txtClave.getPassword());
                usuario = consulta.login(user, clave);

                if (usuario.getNombreUsuario() != null) {

                    JOptionPane.showMessageDialog(null, "Inicio Exitoso");

                    AdminForm adminForm = new AdminForm();
                    adminForm.setVisible(true);
                    adminForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    login.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña o Usuario incorrecto");

                }
            }

        }
    }
}
