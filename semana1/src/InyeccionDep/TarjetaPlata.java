package InyeccionDep;

public class TarjetaPlata implements TarjetaCredito{
	
	@Override
	public void asignarTarjeta() {
		System.out.println("Eres candidat@ a tarjeta Plata");
	}

}
