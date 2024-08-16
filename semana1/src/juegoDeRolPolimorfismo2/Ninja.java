package juegoDeRolPolimorfismo2;

public class Ninja extends Personaje {
    public Ninja() {
        super(50, new Shuriken()); // 50 puntos de vida y usa Shuriken para combate
    }

    @Override
    public void combate() {
        atacar(this); // El Ninja realiza su ataque
    }
}