package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.Persistencia;
import domain.Vehiculo;
import domain.VehiculoTipo;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;


public class Controlador implements ActionListener{

    Persistencia p = new Persistencia();
    ImenuPrincipal vista1 = new menuPrincipal();
    
    ListarVehiculosView vista4 = new ListarVehiculosView();
    
    public Controlador() {
  
        
        p.inicializar();
    }
    
    public void ejecutar(){
        vista1.setControlador(this);
        vista1.ejecutar();
    }
    
    public ArrayList<VehiculoViewModel> getVehiculos(){
        ArrayList<VehiculoViewModel> vehiculos = new ArrayList<>();
        for(Vehiculo vehiculo : p.getVehiculos()) {
            vehiculos.add(new VehiculoViewModel(vehiculo));
        }
        return vehiculos;
    }
    
    public static double[] calcularConsumos(Map<String, Double> vehiculos){
        double consumoElectricos = 0;
        double consumoCombustible= 0;
        for(Map.Entry<String, Double> entry : vehiculos.entrySet()){
           double consumo = 0;
           Optional<Vehiculo> vehiculo = Persistencia.getVehiculo(entry.getKey());
           if(vehiculo.isPresent()){
               consumo = vehiculo.get().calcularConsumo(entry.getValue());
               consumoElectricos += vehiculo.get().esDe(VehiculoTipo.ELECTRICO) ? consumo : 0;
               consumoCombustible += vehiculo.get().esDe(VehiculoTipo.COMBUSTIBLE) ? consumo : 0;
           }
        }
        return new double[] {consumoElectricos, consumoCombustible};
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(ImenuPrincipal.NUEVO_VEHICULO)){
            String tipo = vista1.getTipo();
            if(tipo.equals("Electrico")){
                vista1.ocultar();
                //aqui se ejecutaria la ventana para cargar un auto electrico
            }else if(tipo.equals("Combustible")){
                vista1.ocultar();
                //aqui se ejecutaria la ventana para cargar un auto a combustible
            }
        
        }
        if(e.getActionCommand().equals(ImenuPrincipal.LISTAR_VEHICULOS)){
            System.out.println("ActionCommand: " + e.getActionCommand());
            vista1.ocultar();
            vista4.listarVehiculos(getVehiculos());
            vista4.ejecutar();
        }
        
    }
}
