package juegoDeRolPolimorfismo2;

public class Llamarada implements ComportamientoCombate {
    @Override
    public void EjecutaCombate(Personaje enemigo) {
        System.out.println("El Dragón lanza una llamarada!");
        enemigo.recibirDanio(30); 
    }
}