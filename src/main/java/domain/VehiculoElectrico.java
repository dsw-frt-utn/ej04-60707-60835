package domain;

public class VehiculoElectrico extends Vehiculo {
    private double kwhBase;

    public VehiculoElectrico(String patente, String marca, String modelo, int anio, double capacidadCarga,
                             Sucursal sucursal, double kwhBase) {
        super(VehiculoTipo.ELECTRICO, patente, marca, modelo, anio, capacidadCarga, sucursal);
        this.kwhBase = kwhBase;
    }

    public double calcularConsumo(double kmRecorridos) {
        double total = kmRecorridos/kwhBase;

        if (capacidadCarga <= 1200) {
            total = total + 0.15;
        }

        return total;
    }
}
