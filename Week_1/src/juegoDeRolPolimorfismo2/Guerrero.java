package juegoDeRolPolimorfismo2;

public class Guerrero extends Personaje {
    public Guerrero() {
        super(60, new Espada()); // 60 puntos de vida y usa Espada para combate
    }

    @Override
    public void combate() {
        atacar(this); // El Guerrero realiza su ataque
    }
}