package juegoDeRolPolimorfismo2;

public class Dragon extends Personaje {
    public Dragon() {
        super(200, new Hechizo()); // 40 puntos de vida y usa Hechizo para combate
    }

    @Override
    public void combate() {
        atacar(this); // El Mago realiza su ataque
    }
}
