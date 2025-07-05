package SistemaPrincipal;


import Vistas.LoginForm;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaPrincipal {

    public static void main(String[] args) {
        
         try {
            // Establecer el estilo visual del sistema operativo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SistemaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        loginForm.setTitle("Panel Login");
   
        loginForm.setLocationRelativeTo(null);
   

    }

}
