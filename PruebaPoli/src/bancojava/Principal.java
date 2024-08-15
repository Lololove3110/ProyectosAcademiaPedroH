package bancojava;

import java.util.Scanner;

public class Principal {

    public static Cliente crearCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su numero de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        return new Cliente(nombre, apellido, numeroCuenta);
    }

    public static void main(String[] args) {
        Cliente miCliente = crearCliente();
        System.out.println(miCliente);

        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equalsIgnoreCase("S")) {
            System.out.println("Elije: Depositar (D), Retirar (R), o Salir (S)");
            opcion = scanner.nextLine();

            if (opcion.equalsIgnoreCase("D")) {
                System.out.print("Monto a depositar: ");
                double montoDep = scanner.nextDouble();
                scanner.nextLine(); // Consumir la línea sobrante
                miCliente.depositar(montoDep);
            } else if (opcion.equalsIgnoreCase("R")) {
                System.out.print("Monto a retirar: ");
                double montoRet = scanner.nextDouble();
                scanner.nextLine(); // Consumir la línea sobrante
                miCliente.retirar(montoRet);
            }
            System.out.println(miCliente);
        }

        System.out.println("Gracias por operar en BancoJava");
        scanner.close();
    }
}
