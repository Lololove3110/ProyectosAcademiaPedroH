package juegoDeRolPolimorfismo2;

public class Espada implements ComportamientoCombate {
    @Override
    public void EjecutaCombate(Personaje enemigo) {
        System.out.println("El Guerrero lanza una estocada con la espada!");
        enemigo.recibirDanio(20); // Ajusta el daño según sea necesario
    }
}