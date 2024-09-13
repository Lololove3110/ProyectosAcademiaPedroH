package InyeccionDep;

/*
En esta clase el inyector decide que tipo de tarjeta asignar dependiendo
si se encuentra en uno de los 3 rangos menos de 50,000 , entre 50,000
y 99,999 y de 100,000 para arriba.
 */

public class Inyector {

    public static Cliente inyectarTarjeta(String nombre, double ingresos) {
        TarjetaCredito tarjeta;

        if (ingresos < 50000) {
            tarjeta = new TarjetaPlata();
        } else if (ingresos < 100000) {
            tarjeta = new TarjetaOro();
        } else {
            tarjeta = new TarjetaDiamante();
        }

        return new Cliente(nombre, ingresos, tarjeta);
    }
}