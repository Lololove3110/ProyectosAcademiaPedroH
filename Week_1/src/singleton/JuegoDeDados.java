package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*La clase de singleton permite que multiples jugadores puedan 
 * ingresar a la partida y se les asigne un numero sin necesidad de 
 * crear nuevos objetos. Todo lo hace a partir de un array
 * 
 */
public class JuegoDeDados {
    // Aqui se crea el singleton
    private static JuegoDeDados instancia;
    // Lista de jugadores que participan en el juego
    private List<Jugador> jugadores;

    //Evitamos que no suceda la creacion de multiples instancias y que todo apunte al singleton
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

    // Aqui se aplica el singleton para obtener una unica instancia de clase
    public static JuegoDeDados getInstancia(int numeroDeJugadores) {
        if (instancia == null) {
            instancia = new JuegoDeDados(numeroDeJugadores);
        }
        return instancia;
    }

    // Aqui se asigna un dado a cada jugador y se guardan los puntos
    public void jugar() {
        Dado dado = new Dado();
        for (Jugador jugador : jugadores) {
            int resultado = dado.lanzar();
            jugador.sumarPuntos(resultado);
            System.out.println(jugador.getNombre() + " sacó " + resultado + " puntos.");
        }
        mostrarGanador();
    }

    // Este método compara todos los jugadores y saca el ganador con mayor puntaje
    private void mostrarGanador() {
        Jugador ganador = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() > ganador.getPuntaje()) {
                ganador = jugador;
            }
        }
        System.out.println("El ganador es " + ganador.getNombre() + " con " + ganador.getPuntaje() + " puntos.");
    }

    // Metodo principal para ejecutar el juego
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Se pide el numero de jugadores
        System.out.print("Ingrese el número de jugadores: ");
        int numeroDeJugadores = scanner.nextInt();
        scanner.nextLine();  // Limpia el buffer de entrada

        // Crea la instancia del juego
        JuegoDeDados juego = JuegoDeDados.getInstancia(numeroDeJugadores);
        
        // Inicia el juego
        juego.jugar();
    }
}

