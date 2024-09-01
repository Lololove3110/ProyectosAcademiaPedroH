package builder;

public class CustomPlayer {
	
	public static void main(String[] args) {
		//Create the director to assign the characteristics
		Director director = new Director();
		//Add characters
		Ninja ninjaBuilder = new Ninja();
		Wizard wizardBuilder = new Wizard();
		
		//Give the characters the attributes
		director.makePlayer1(ninjaBuilder);
		director.makePlayer2(wizardBuilder);
		
		//Get the attributes
		Ninja1 ninja = ninjaBuilder.getResult();
		Wizard1 wizard = wizardBuilder.getResult();
		
		//Print the final output
		System.out.println("Character player 1: \n"+ninja);
		System.out.println("Character player 2: \n"+wizard);	
	} 
}
