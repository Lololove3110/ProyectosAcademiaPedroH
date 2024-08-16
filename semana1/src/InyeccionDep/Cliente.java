package InyeccionDep;

public class Cliente {

    private String nombre;
    private double ingresosMensuales;
    private TarjetaCredito tarjeta; 
    // Inyección de dependencias por medio de constructor

    public Cliente(String nombre, double ingresosMensuales, TarjetaCredito tarjeta) {
        this.nombre = nombre;
        this.ingresosMensuales = ingresosMensuales;
        this.tarjeta = tarjeta;
    }

    public void mostrarInformacion() {
        System.out.println(nombre + " tiene ingresos de " + ingresosMensuales + " pesos.");
        tarjeta.asignarTarjeta();
    }
}