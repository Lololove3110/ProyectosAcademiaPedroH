package juegoDeRolPolimorfismo2;

public class Mago extends Personaje {
    public Mago() {
        super(40, new Hechizo()); // 40 puntos de vida y usa Hechizo para combate
    }

    @Override
    public void combate() {
        atacar(this); // El Mago realiza su ataque
    }
}
