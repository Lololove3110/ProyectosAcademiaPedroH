package InyeccionDep;

public class TarjetaOro implements TarjetaCredito{
	
	@Override
	public void asignarTarjeta() {
		System.out.println("Eres candidat@ a tarjeta Oro");
	}

}
