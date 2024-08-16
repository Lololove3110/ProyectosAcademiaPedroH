package InyeccionDep;

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