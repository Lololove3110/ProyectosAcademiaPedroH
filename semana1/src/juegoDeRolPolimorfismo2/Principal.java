package juegoDeRolPolimorfismo2;


public class Principal {

    public static void main(String[] args) {
        // Crear personajes
        Guerrero guerrero = new Guerrero();
        Ninja ninja = new Ninja();
        Mago mago = new Mago();
        Dragon dragon = new Dragon();

        // Realizar ataques y mostrar la vida restante
        guerrero.atacar(dragon);
        System.out.println("Vida del Dragón: " + dragon.getPuntosDeVida());
        
     // Ataques del Dragón
        dragon.atacar(guerrero);
        System.out.println("Vida del Guerrero: " + guerrero.getPuntosDeVida());

        ninja.atacar(dragon);
        System.out.println("Vida del Dragón: " + dragon.getPuntosDeVida());
        
        dragon.atacar(ninja);
        System.out.println("Vida del Ninja: " + ninja.getPuntosDeVida());

        mago.atacar(dragon);
        System.out.println("Vida del Dragón: " + dragon.getPuntosDeVida());

        dragon.atacar(mago);
        System.out.println("Vida del Mago: " + mago.getPuntosDeVida());
    }
}