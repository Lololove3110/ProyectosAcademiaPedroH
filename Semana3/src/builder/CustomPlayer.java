package builder;

public class CustomPlayer {
	
	public static void main(String[] args) {
		Director director = new Director();
		Ninja ninjaBuilder = new Ninja();
		Wizard wizardBuilder = new Wizard();
		director.makePlayer1(ninjaBuilder);
		director.makePlayer2(wizardBuilder);
		Ninja1 ninja = ninjaBuilder.getResult();
		Wizard1 wizard = wizardBuilder.getResult();
		System.out.println("Character player 1: \n"+ninja);
		System.out.println("Character player 2: \n"+wizard);

		
		
		
		
		
		
	} 

}
