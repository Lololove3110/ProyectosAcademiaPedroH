package singleton;

import java.util.Random;


/*Esta clase simula la tirada de un dado
 * primero declara la variable random
 * despues hace un constructor que asigna un numero a random
 * y por ultimo el metodo que simula ver como tal el dado
 */

public class Dado {
    private Random random;

    public Dado() {
        random = new Random();
    }

    public int lanzar() {
        return random.nextInt(6) + 1;
    }
}
