

import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    public static void main(String[] args) {
        Ventana1 ventana = null;
        try {
            ventana = new Ventana1();
        }
        catch (Exception e) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, e);
        }
        ventana.setVisible(true);
    }
}
