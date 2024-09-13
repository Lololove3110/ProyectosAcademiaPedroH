package InyeccionDep;


/*Esta clase es el contrato que sera usado
por todas las clases del tipo TarjetaCredito
y el método que existe se implementa en cada una de las tarjetas

*/
public interface TarjetaCredito {
	void asignarTarjeta();

}

/*Este es un ejemplo de como sobreescribe la funcion 
usando el metodo de esta interfaz
	@Override
	public void asignarTarjeta() {
		System.out.println("Eres candidat@ a tarjeta Oro");
	}

}

*/