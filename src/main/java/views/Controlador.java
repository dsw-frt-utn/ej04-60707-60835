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
    
    IAgregarVehiculo vista2 = new AgregarVehiculoE();
    IAgregarVehiculo vista3 = new AgregarVehiculoC();
    ListarVehiculosView vista4 = new ListarVehiculosView();
    
    public Controlador() {
        vista2.setControlador(this);
        vista3.setControlador(this);
        p.inicializar();
    }
    
    public void ejecutar(){
        vista2.ejecutar();
        vista2.actualizar(p.getSucursales());
        vista3.ejecutar();
        vista3.actualizar(p.getSucursales());
        vista4.ejecutar();
        
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
        
        
        if(e.getActionCommand().equals(IAgregarVehiculo.AGREGAR_VEHICULO_E)){
            p.agregarVehiculo(((AgregarVehiculoE) vista2).guardarVehiculo());
            vista4.listarVehiculos(getVehiculos());
            
        }
        if(e.getActionCommand().equals(IAgregarVehiculo.AGREGAR_VEHICULO_C)){
            p.agregarVehiculo(((AgregarVehiculoC) vista3).guardarVehiculo());
            vista4.listarVehiculos(getVehiculos());
            
        }
    }
}
