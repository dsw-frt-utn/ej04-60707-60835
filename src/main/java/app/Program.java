package app;

import data.Persistencia;
import java.util.InvalidPropertiesFormatException;
import views.*;

public class Program {
    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        
        /*ListarVehiculosView view = new ListarVehiculosView();
        view.setVisible(true);*/
        Controlador c=new Controlador();
        c.ejecutar();
    }
}
