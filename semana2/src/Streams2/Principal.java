package Streams2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {
	private static Tienda[] arrayDeTiendas = {
            new Tienda("Tienda1", "Mac Pro", 5, 3000),
            new Tienda("Tienda2", "Windows Surface", 12, 1500),
            new Tienda("Tienda3", "HP 640", 8, 800),
            new Tienda("Tienda4", "Mac Pro", 15, 3200),
            new Tienda("Tienda5", "Windows Surface", 7, 1400),
            new Tienda("Tienda6", "HP 640", 11, 900),
            new Tienda("Tienda7", "Windows Surface", 6, 1600),
            new Tienda("Tienda8", "HP 640", 14, 850),
            new Tienda("Tienda9", "Mac Pro", 9, 2800),
            new Tienda("Tienda10", "Windows Surface", 13, 1550),
            new Tienda("Tienda11", "HP 640", 2, 750),
            new Tienda("Tienda12", "Windows Surface", 3, 1450),
            new Tienda("Tienda13", "Mac Pro", 18, 3100),
            new Tienda("Tienda14", "HP 640", 1, 800),
            new Tienda("Tienda15", "Windows Surface", 20, 1700)
    };

	public static void main(String[] args) {

        // Imprimir lista inicial de tiendas
        System.out.println("Lista inicial de tiendas:");
        Arrays.stream(arrayDeTiendas).forEach(System.out::println);

        List<Tienda> listaTiendas = Arrays.stream(arrayDeTiendas)
                // 1. Filtrar tiendas a más de 10 km de distancia
                .filter(t -> t.getDistancia() <= 10)
                // 2. Eliminar tiendas que venden Mac Pro
                .filter(t -> !"Mac Pro".equals(t.getProducto()))
                // 3. Eliminar tiendas con precio muy alto (por ejemplo, más de 1600)
                .filter(t -> t.getPrecio() <= 1600)
                // 4. Ordenar tiendas por distancia de menor a mayor
                .sorted(Comparator.comparingInt(Tienda::getDistancia))
                .collect(Collectors.toList());

        // Imprimir lista final de tiendas después de aplicar los filtros y ordenación
        System.out.println("\nLista final de tiendas:");
        listaTiendas.forEach(System.out::println);
    }

}
