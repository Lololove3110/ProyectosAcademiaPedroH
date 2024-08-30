package oberver;
//This is the main class, where i apply attach and detach
public class Principal {
	public static void main(String[] args) {
		Player player1 = new Player();
		
		System.out.println("Action 1: ");

		Observer jump = new Jump(player1);
		
		new ComboAtack("kick,punch,punch", player1);
		new Eat("Banana",player1);

		player1.action();
		System.out.println("---------------");
		System.out.println("Action 2: ");
		player1.detach(jump);
		player1.action();
		
		System.out.println("---------------");
		System.out.println("Action 3: ");
		player1.detach(new Eat("Banana",player1));
		new ComboAtack("punch, kick, kick", player1);
		player1.action();
		System.out.println("---------------");
		System.out.println("Action 4: ");
		player1.detach(new ComboAtack("punch, kick, kick", player1));
		player1.detach(new ComboAtack("kick,punch,punch", player1));
		new Eat("Burger",player1);
		new Eat("Ribs",player1);
		player1.action();

		
		
		
	}
		

		
}
