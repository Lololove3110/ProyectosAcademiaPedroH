package InyeccionDep;

public class Principal {

    public static void main(String[] args) {
        // Crear y asignar tarjetas a 10 clientes
        Cliente[] clientes = new Cliente[10];
        double[] ingresos = {45000, 120000, 60000, 20000, 150000, 80000, 30000, 50000, 90000, 140000};
        String[] nombres = {"Pedro", "Jahir", "Alex", "Angel", "Lucia", "Ximena", "Maria", "Esthela", "Basilio", "Gael"};

        for (int i = 0; i < 10; i++) {
            clientes[i] = Inyector.inyectarTarjeta(nombres[i], ingresos[i]);
        }

        //Imprime los clientes
        for (Cliente cliente : clientes) {
            cliente.mostrarInformacion();
        }
    }
}