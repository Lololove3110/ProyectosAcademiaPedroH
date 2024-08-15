package singleton;

import java.util.Random;

// Clase que representa un dado en el juego
public class Dado {
    // Generador de números aleatorios para simular el lanzamiento del dado
    private Random random;

    // Constructor que inicializa el generador de números aleatorios
    public Dado() {
        random = new Random();
    }

    // Método para simular el lanzamiento del dado
    public int lanzar() {
        // Genera un número aleatorio entre 1 y 6 (ambos inclusive)
        return random.nextInt(6) + 1;
    }
}
