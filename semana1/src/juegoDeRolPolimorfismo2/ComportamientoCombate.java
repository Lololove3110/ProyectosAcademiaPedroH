package juegoDeRolPolimorfismo2;

/* aqui se define los diferentes comportamientos del personaje y el enemigo, todavia falta sobreescribir 
 * todos los tipos de comportamiento de los ataques
 * Se muestran en las clases Shuriken, Hechizo, Espada y Llamarada
 * 
 */
public interface ComportamientoCombate {
	void EjecutaCombate(Personaje enemigo);

}

/*Ejemplo de como se sobre escribe cada clase
* public class Espada implements ComportamientoCombate {
*  @Override
*   public void EjecutaCombate(Personaje enemigo) {
*     System.out.println("El Guerrero lanza una estocada con la espada!");  se declara el ataque
*      enemigo.recibirDanio(20); se hace el daño pero no acepta java ñ
*   }
*}
/*