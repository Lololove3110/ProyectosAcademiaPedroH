package Streams;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
	private static Estudiante[] arrayOfEstudiantes = {
            new Estudiante("Carlos", 60, 70),
            new Estudiante("Ana", 80, 85),
            new Estudiante("Luis", 50, 55),
            new Estudiante("María", 90, 95),
            new Estudiante("Jose", 45, 50),
            new Estudiante("Elena", 85, 80),
            new Estudiante("Fernando", 100, 90),
            new Estudiante("Lucía", 40, 45),
            new Estudiante("Miguel", 55, 65),
            new Estudiante("Sofia", 95, 90),
            new Estudiante("Pablo", 30, 35),
            new Estudiante("Andrea", 75, 80),
            new Estudiante("Jorge", 65, 70),
            new Estudiante("Clara", 60, 60),
            new Estudiante("Alberto", 70, 75),
            new Estudiante("Raquel", 85, 90),
            new Estudiante("Manuel", 40, 45),
            new Estudiante("Teresa", 80, 85),
            new Estudiante("Pedro", 35, 40),
            new Estudiante("Laura", 95, 100)
            
	};
	public static void main(String[] args) {

        System.out.println("Estudiantes fuera del filtro");

        List<Estudiante> listaEstudiantes = Arrays.stream(arrayOfEstudiantes)
                // 1. Filtrar estudiantes con promedio menor a 65 en ambos periodos
                .filter(e -> (e.getCalificacionPeriodo1() + e.getCalificacionPeriodo2()) / 2.0 < 65)
                .peek(e -> System.out.println("Filtrado: " + e))
                .collect(Collectors.toList());

        // 2. Añadir cinco puntos a las calificaciones del primer y segundo periodo
        listaEstudiantes.forEach(e -> {
            e.setCalificacionPeriodo1(e.getCalificacionPeriodo1() + 5);
            e.setCalificacionPeriodo2(e.getCalificacionPeriodo2() + 5);
        });

        // 3. Ordenar estudiantes por promedio más alto
        List<Estudiante> estudiantesOrdenados = Arrays.stream(arrayOfEstudiantes)
                .sorted(Comparator.comparingDouble(
                        e -> -(e.getCalificacionPeriodo1() + e.getCalificacionPeriodo2()) / 2.0))
                .collect(Collectors.toList());

        // 4. Obtener los cinco mejores estudiantes
        List<Estudiante> top5Estudiantes = estudiantesOrdenados.stream()
                .limit(5)
                .collect(Collectors.toList());

        // Imprimir resultados
        System.out.println("\nTop 5 Estudiantes por Promedio:");
        top5Estudiantes.forEach(System.out::println);
    }

}
