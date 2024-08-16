package juegoDeRolPolimorfismo2;

public class Shuriken implements ComportamientoCombate {
    @Override
    public void EjecutaCombate(Personaje enemigo) {
        System.out.println("El Ninja lanza un shuriken!");
        enemigo.recibirDanio(15); 
    }
}