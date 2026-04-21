/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package views;
/**
 *
 * @author Maxi
 */
public interface ImenuPrincipal {
    public void setControlador(Controlador control);
    public void ejecutar();
    public String getTipo();
    public void ocultar();
    public static final String NUEVO_VEHICULO = "newVehicle";
    public static final String LISTAR_VEHICULOS = "listVehicle";
}
