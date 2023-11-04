package Principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import org.xml.sax.SAXException;
import Vista.Ventana1;

/**
 *
 * @author MonkeeBoi
 */
public class Main {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException{
        
        Ventana1 ventana = new Ventana1();
        ventana.setVisible(true);
            
    }
}
