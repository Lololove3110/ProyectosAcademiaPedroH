package singleton;

// Clase que representa a un jugador en el juego
public class Jugador {
    // Nombre del jugador
    private String nombre;
    // Puntaje acumulado del jugador
    private int puntaje;

    // Constructor para inicializar el nombre del jugador y su puntaje
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0; // Puntaje inicial es 0
    }

    // Método para sumar puntos al puntaje acumulado del jugador
    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    // Método para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el puntaje acumulado del jugador
    public int getPuntaje() {
        return puntaje;
    }
}
