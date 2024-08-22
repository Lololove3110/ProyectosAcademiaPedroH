package CollectionArrayMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Array {
	public static void main(String[] args) {
		
		//Solo se tiene que escribir <integer> del lado izquierdo 
		//Eso es lo de los generics
		List<Integer> list0 = new ArrayList<>();
		Map<Long,List<Integer>> mapList = new HashMap<>();
		
		
		Collection<String> list = new ArrayList<>();
		//add añade y remove y remueve y si los ponemos dentro de un sysout
		//Se espera que de true si si lo añade y false si no 
		
		System.out.println(list.add("Sparrow"));//true
		list.add("hawk");
		list.add("hawk");
		System.out.println(list.remove("hawk"));
		


		System.out.println(list.size());//ve el tamaño
		System.out.println(list.isEmpty());//obersva si esta vacía
		System.out.println(list.contains("hawk")); //Checa si esta en la lista:True
		System.out.println(list.contains("hola")); //Checa si esta en la lista:False

		
		
		
		//en el caso de los set no podemos añadir dos objetos iguales
		//en este caso al volver a intentar añadir Sparrow ya no funciona
		Collection<String> set = new HashSet<>();//True
		System.out.println(set.add("Sparrow"));
		System.out.println(set.add("Sparrow"));
		
		
		
		
		
	}
	

}
