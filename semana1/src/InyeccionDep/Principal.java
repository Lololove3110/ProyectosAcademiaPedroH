package InyeccionDep;

/*
En esta clase decido determinar la inyeccion dependiendo del valor de la lista
de ingresos. El ingreso pertenece a un cliente y finalmente semuestra 
que tipo de tarjeta conseguirá el cliente
 */
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