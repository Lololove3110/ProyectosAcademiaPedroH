package singleton;


/*Esta clase jugador revisa los nombres y guarda
 * el puntaje de los  jugadores despues de recibir la tirada
 * 
 */
public class Jugador {
	
    private String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0; 
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
