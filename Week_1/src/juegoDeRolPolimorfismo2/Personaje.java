package juegoDeRolPolimorfismo2;

/*
 * Esta clase tiene la finaldiad el fin de mostrar
 * las interacciones entre los personajes al atacar
 * o ser atacados
 * 
 * 
 */
public abstract class Personaje implements Combatiente {
    protected int puntosDeVida;
    protected ComportamientoCombate comportamientoCombate;

 // Este es el constructor de los puntos de vida y el daño que haran dependiendo del ataque
    public Personaje(int puntosDeVida, ComportamientoCombate comportamientoCombate) {
        this.puntosDeVida = puntosDeVida;
        this.comportamientoCombate = comportamientoCombate;
    }
    
//se ejecuta el ataque
    public void atacar(Personaje enemigo) {
        comportamientoCombate.EjecutaCombate(enemigo);
    }
// se resta la vida dependiendo del daño realizado por el ataque
    public void recibirDanio(int danio) {
        puntosDeVida -= danio;
        System.out.println(this.getClass().getSimpleName() + " recibe " + danio + " puntos de daño. Vida restante: " + puntosDeVida);
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }
}

/*Ejemplo de como esta clase logra que cada personaje pueda contar con daño
 * especifico, tipo de ataque y vida
 * public class Mago extends Personaje {
    public Mago() {
        super(40, new Hechizo()); // 40 puntos de vida y usa Hechizo para combate
    }

    @Override
    public void combate() {
        atacar(this); // El Mago realiza su ataque
    }
}
 */


