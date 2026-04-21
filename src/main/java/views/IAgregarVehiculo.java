/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package views;

import domain.Sucursal;
import java.util.ArrayList;

/**
 *
 * @author Maxi
 */
public interface IAgregarVehiculo {
    public void setControlador(Controlador control);
    public void ejecutar();
    public void actualizar(ArrayList<Sucursal> lista);
    public void ocultar();
    
    public static final String AGREGAR_VEHICULO_E= "saveVehicleE";
    public static final String AGREGAR_VEHICULO_C= "saveVehicleC";
}
