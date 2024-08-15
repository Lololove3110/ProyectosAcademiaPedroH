package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase Singleton que controla la lógica del juego de tirar dados
public class JuegoDeDados {
    // Única instancia de la clase (Singleton)
    private static JuegoDeDados instancia;
    // Lista de jugadores que participan en el juego
    private List<Jugador> jugadores;

    // Constructor privado para evitar la creación de múltiples instancias
    private JuegoDeDados(int numeroDeJugadores) {
        jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Pide al usuario que ingrese el nombre de cada jugador
        for (int i = 1; i <= numeroDeJugadores; i++) {
            System.out.print("Ingrese el nombre del Jugador " + i + ": ");
            String nombre = scanner.nextLine();
            jugadores.add(new Jugador(nombre));
        }
    }

    // Método estático para obtener la única instancia de la clase
    public static JuegoDeDados getInstancia(int numeroDeJugadores) {
        if (instancia == null) {
            instancia = new JuegoDeDados(numeroDeJugadores);
        }
        return instancia;
    }

    // Método que controla el flujo principal del juego
    public void jugar() {
        Dado dado = new Dado();
        for (Jugador jugador : jugadores) {
            int resultado = dado.lanzar();
            jugador.sumarPuntos(resultado);
            System.out.println(jugador.getNombre() + " sacó " + resultado + " puntos.");
        }
        mostrarGanador();
    }

    // Método privado para determinar y mostrar el ganador del juego
    private void mostrarGanador() {
        Jugador ganador = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() > ganador.getPuntaje()) {
                ganador = jugador;
            }
        }
        System.out.println("El ganador es " + ganador.getNombre() + " con " + ganador.getPuntaje() + " puntos.");
    }

    // Método principal para ejecutar el juego
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicita al usuario el número de jugadores
        System.out.print("Ingrese el número de jugadores: ");
        int numeroDeJugadores = scanner.nextInt();
        scanner.nextLine();  // Limpia el buffer de entrada

        // Crea la instancia del juego
        JuegoDeDados juego = JuegoDeDados.getInstancia(numeroDeJugadores);
        
        // Inicia el juego
        juego.jugar();
    }
}

