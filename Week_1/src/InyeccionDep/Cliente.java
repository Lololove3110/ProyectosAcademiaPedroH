package InyeccionDep;


/*
En esta clase se definen los atributos de los clientes
y se crea el constructor para hacer la inyección.
Adicionalmente se crea un metodo para que el output
sea mas claro mostrando la información del cliente primero
 */
public class Cliente {

    private String nombre;
    private double ingresosMensuales;
    private TarjetaCredito tarjeta; 

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