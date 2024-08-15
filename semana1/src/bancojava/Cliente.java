package bancojava;

public class Cliente extends Persona implements CuentaBancaria{
	private String numeroCuenta;
	private double balance;
	
	public Cliente(String nombre, String apellido, String numeroCuenta) {
		super(nombre,apellido);
		this.numeroCuenta = numeroCuenta;
		this.balance = 0;
		
	}

	
	@Override
	public String toString() {
		return "Cliente: " + nombre + " " + apellido + "\nBalance de cuenta" + numeroCuenta + ": $" + balance;
		
	}
	@Override 
	public void depositar(double monto) {
		balance += monto;
		System.out.println("Deposito aceptado");

	}
	@Override
	public void retirar(double monto) {
		if(balance >= monto) {
			balance -= monto;
			System.out.println("Retiro realizado");
		
			
		} else {
			System.out.println("Fondos insuficientes");
			
			
		}
	}
}
