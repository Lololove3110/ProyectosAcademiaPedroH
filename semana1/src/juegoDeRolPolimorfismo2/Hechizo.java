package juegoDeRolPolimorfismo2;

public class Hechizo implements ComportamientoCombate {
    @Override
    public void EjecutaCombate(Personaje enemigo) {
        System.out.println("El Mago lanza un hechizo!");
        enemigo.recibirDanio(25); // Ajusta el daño según sea necesario
    }
}