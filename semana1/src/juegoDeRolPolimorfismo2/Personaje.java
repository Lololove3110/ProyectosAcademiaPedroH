package juegoDeRolPolimorfismo2;


public abstract class Personaje implements Combatiente {
    protected int puntosDeVida;
    protected ComportamientoCombate comportamientoCombate;

    public Personaje(int puntosDeVida, ComportamientoCombate comportamientoCombate) {
        this.puntosDeVida = puntosDeVida;
        this.comportamientoCombate = comportamientoCombate;
    }

    public void atacar(Personaje enemigo) {
        comportamientoCombate.EjecutaCombate(enemigo);
    }

    public void recibirDanio(int danio) {
        puntosDeVida -= danio;
        System.out.println(this.getClass().getSimpleName() + " recibe " + danio + " puntos de daño. Vida restante: " + puntosDeVida);
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }
}